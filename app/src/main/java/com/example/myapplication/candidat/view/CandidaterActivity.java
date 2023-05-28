package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.frontend.Agence.Agence;
import com.example.myapplication.models.AppUser;
import com.example.myapplication.models.Vacancies;
import com.example.myapplication.services.it20133290.VacancyServicesImp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class CandidaterActivity extends AppCompatActivity {

    EditText email, tp, link, pass, repass, name,prenom,DB,NT, adresse;
    Button submit, chooseImg,chooseIcv;
    ProgressBar pb;
    ImageView imgUpload,icvUpload;
    Vacancies vacancies;
    AppUser appUser;
    Agence agence;
    VacancyServicesImp vacSer = new VacancyServicesImp();
    private StorageReference mStorageRef;
    private static final int PICK_IMAGE_REQUEST = 1;
    String imageName;

    FirebaseAuth.AuthStateListener authStateListener;
    Uri mImageUri;
    Uri mCvUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidater);
        getSupportActionBar().hide();

        name = findViewById(R.id.etUserOrganism);
        prenom = findViewById(R.id.etUserLastName);
        email = findViewById(R.id.etUserEmail);
        tp = findViewById(R.id.etUserContact);
        NT = findViewById(R.id.etUserNT);
        DB = findViewById(R.id.etUserDB);
        pass = findViewById(R.id.etUserPassword);
        repass = findViewById(R.id.etReUserPassword);
        submit = findViewById(R.id.btnRegister);
        imgUpload = findViewById(R.id.ivUploadProfImg);
        chooseImg = findViewById(R.id.btnUploadProfImg);
        icvUpload = findViewById(R.id.ivUploadCv);
        chooseIcv = findViewById(R.id.btnUploadCv);
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

                //registerWithEmail(userEmail, userPassword);

                vacSer.addNewCandidat(CandidaterActivity.this, name, prenom,NT,DB,tp, adresse,email, mCvUri, pass, repass,  mImageUri, pb);

            }
        });

        // Authentification listener
        FirebaseAuth auth = FirebaseAuth.getInstance();
        authStateListener = firebaseAuth -> {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                // Utilisateur connecté
                //addUserToDatabase(user);
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

}
