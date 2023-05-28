package com.example.myapplication.frontend.Agence;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.frontend.Employee.Emp_RegisterActivity;
import com.example.myapplication.models.AppUser;
import com.example.myapplication.models.Vacancies;
import com.example.myapplication.services.it20133290.VacancyServicesImp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.FirebaseException;
import com.google.android.material.snackbar.Snackbar;
import android.widget.Toast;

public class Agence_RegisterActivity extends AppCompatActivity {

    EditText email, tp, link, pass, repass, interim, adresse;
    Button submit, chooseImg;
    ProgressBar pb;
    ImageView imgUpload;
    Vacancies vacancies;
    AppUser appUser;
    Agence agence;
    VacancyServicesImp vacSer = new VacancyServicesImp();
    private StorageReference mStorageRef;
    private static final int PICK_IMAGE_REQUEST = 1;
    String imageName;

    FirebaseAuth.AuthStateListener authStateListener;
    Uri mImageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_agence);
        getSupportActionBar().hide();

        interim = findViewById(R.id.etUserOrganism);
        email = findViewById(R.id.etUserEmail);
        tp = findViewById(R.id.etUserContact);
        link = findViewById(R.id.etUserLink);
        pass = findViewById(R.id.etUserPassword);
        repass = findViewById(R.id.etReUserPassword);
        submit = findViewById(R.id.btnRegister);
        imgUpload = findViewById(R.id.ivUploadProfImg);
        chooseImg = findViewById(R.id.btnUploadProfImg);
        adresse = findViewById(R.id.etUserAddress);
        pb = findViewById(R.id.pbUploadImage);

        mStorageRef = FirebaseStorage.getInstance("gs://hireme-2e86a.appspot.com/").getReference("uploads");

        chooseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //   uploadFile();
                String userEmail = email.getText().toString().trim();
                String userPassword = pass.getText().toString().trim();

                registerWithEmail(userEmail, userPassword);

                vacSer.addNewAgence(Agence_RegisterActivity.this,interim,tp,email,link,adresse,pass,repass,mImageUri,pb);

            }
        });

        // Authentification listener
        FirebaseAuth auth = FirebaseAuth.getInstance();
        authStateListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                // Utilisateur connecté
                addUserToDatabase(user);
            } else {
                // Utilisateur déconnecté
            }
        };

    }

    private void openFileChooser() {
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(i, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK &&
                data != null && data.getData() != null) {
            mImageUri = data.getData();

            Picasso.with(this).load(mImageUri).into(imgUpload);

        }
    }

    // Méthode pour ajouter l'utilisateur à la base de données
    private void addUserToDatabase(FirebaseUser user) {
        String userId = user.getUid();
        String userInterim = interim.getText().toString();
        String userTp = tp.getText().toString();
        String userLink = link.getText().toString();
        String userAdresse = adresse.getText().toString();
        String userEmail = email.getText().toString();

        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child("AppAgency").child(userId);
        userRef.child("interim").setValue(userInterim);
        userRef.child("tp").setValue(userTp);
        userRef.child("link").setValue(userLink);
        userRef.child("adresse").setValue(userAdresse);
        userRef.child("email").setValue(userEmail);


        vacSer.addNewAgence(Agence_RegisterActivity.this,interim,tp,email,link,adresse,pass,repass,mImageUri,pb);
        // Une fois les informations enregistrées avec succès, vous pouvez afficher un message ou effectuer une action supplémentaire
        Toast.makeText(Agence_RegisterActivity.this, "User information added to database", Toast.LENGTH_SHORT).show();
    }

        // Inscription par e-mail
        // Inscription par e-mail
        private void registerWithEmail(String email, String password) {
            FirebaseAuth auth = FirebaseAuth.getInstance();
            auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // L'inscription par e-mail a réussi
                                FirebaseUser user = auth.getCurrentUser();

                                // Envoi de l'e-mail de vérification
                                if (user != null) {
                                    user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(Agence_RegisterActivity.this, "Registered with email", Toast.LENGTH_SHORT).show();
                                                // Ajouter l'agence après la vérification de l'e-mail
                                                addUserToDatabase(user);
                                            } else {
                                                Toast.makeText(Agence_RegisterActivity.this, "Failed to send verification email", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }
                            } else {
                                // L'inscription par e-mail a échoué
                                Toast.makeText(Agence_RegisterActivity.this, "Failed to register with email", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }


}
