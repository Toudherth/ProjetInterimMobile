package com.example.myapplication.candidat.view;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.candidat.model.Candidat;

public class UpdateCandidatActivity extends AppCompatActivity {

    Candidat candidat;
    private static final int PICKFILE_REQUEST_CODE = 100;

    private EditText tnom, tprenom,tnationnalite,tdatenaissance,description, temail,tpassword, tville, tconfirmpassword, tcv, tnumerotel;
    private Button bvalider, bannuler, bajoutercv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_candidat);

        // menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour
        // déclaration d'attributs
        bvalider =findViewById(R.id.buttonaouter);
        bannuler= findViewById(R.id.buttonanuuler);
        bajoutercv= findViewById(R.id.buttonajoutcv);
        //text
        tnom= findViewById(R.id.txtNom);
        tprenom= findViewById(R.id.txtPrenom);
        tnationnalite= findViewById(R.id.txtNationnalit);
        tdatenaissance= findViewById(R.id.txtdatenaissance);
        temail= findViewById(R.id.etemail);
        tpassword= findViewById(R.id.etmdp);
        tconfirmpassword= findViewById(R.id.etmdpverif);
        tnumerotel= findViewById(R.id.txtNumero2);
        tville= findViewById(R.id.txtville);
        tcv=findViewById(R.id.txtcv);
        description = findViewById(R.id.editTextComment);



        // recuperation des data de saisie
        String nom = tnom.getText().toString();
        String prenom = tprenom.getText().toString();
        String nationnalite = tnationnalite.getText().toString();
        String datenaissance = tdatenaissance.getText().toString();
        String ville = tville.getText().toString();
        String numerotel = tnumerotel.getText().toString();
        String email = temail.getText().toString();
        String password = tpassword.getText().toString();
        String confirmpassword = tconfirmpassword.getText().toString();
        String cv = tcv.getText().toString();
        String lettre = description.getText().toString();

        //instance
        candidat = new Candidat();




        bvalider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = temail.getText().toString();
                String password = tpassword.getText().toString();
                String confirmPassword = tconfirmpassword.getText().toString();


                if (!password.equals(confirmPassword)) {
                    // Les mots de passe ne correspondent pas
                    String message = "Please confirm your password";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

                } else {

                    // la partie ce connecter

                }
            }
        });


        bannuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tnom.setText(""); // Vider le champ de texte du nom
                tprenom.setText(""); // Vider le champ de texte du prénom
                tnationnalite.setText(""); // Vider le champ de texte de la nationalité
                tdatenaissance.setText(""); // Vider le champ de texte de la date de naissance
                tville.setText(""); // Vider le champ de texte de la ville
                tnumerotel.setText(""); // Vider le champ de texte du numéro de téléphone
                temail.setText(""); // Vider le champ de texte de l'email
                tpassword.setText(""); // Vider le champ de texte du mot de passe
                tconfirmpassword.setText(""); // Vider le champ de texte de la confirmation du mot de passe
                tcv.setText(""); // Vider le champ de texte du CV
                description.setText(""); // Vider le champ de texte de la lettre de description

                Intent intent = new Intent(UpdateCandidatActivity.this, ProfilCandidatActivity.class);
                startActivity(intent);
                finish();
            }
        });





    }




    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Action à réaliser lorsque le bouton de retour est cliqué
            Intent intent = new Intent(this, ProfilCandidatActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //
    private void showFileChooser() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // tous les types de fichiers
        intent.addCategory(Intent.CATEGORY_OPENABLE);

        try {
            startActivityForResult(
                    Intent.createChooser(intent, "Select file"),
                    PICKFILE_REQUEST_CODE
            );
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "Please install a file manager", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICKFILE_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri fileUri = data.getData();
            String filePath = getRealPathFromUri(this, fileUri);
            tcv.setText(filePath);
            //System.out.println(" je suis le path----------- : "+filePath);

            // faire qlq chose avec le chemin selectionner
        }
    }
    private String getRealPathFromUri(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            String[] projection = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(uri, projection, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

}