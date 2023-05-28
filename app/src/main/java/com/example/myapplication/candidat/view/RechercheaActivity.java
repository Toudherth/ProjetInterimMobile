package com.example.myapplication.candidat.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.google.android.material.textfield.TextInputLayout;

public class RechercheaActivity extends AppCompatActivity {
    private TextInputLayout tintituler, tmetier,tzone,tperiode;
    private Button brecherche;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherchea);

        // menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour

        // Récupération des champs de saisie
        EditText intitulerPosteEditText = findViewById(R.id.tintetuler);
        EditText metierEditText = findViewById(R.id.tmetier);
        EditText zoneRechercheEditText = findViewById(R.id.tville);
        EditText periodeEditText = findViewById(R.id.tperiode);

        brecherche= findViewById(R.id.search_button);



        // Récupération des CheckBox
        CheckBox cdiCheckBox = findViewById(R.id.etcdi);
        CheckBox cddCheckBox = findViewById(R.id.etcdd);
        CheckBox alternanceCheckBox = findViewById(R.id.etalternance);
        CheckBox stageCheckBox = findViewById(R.id.etstage);

        // Exemple d'utilisation :
        String intitulerPoste = intitulerPosteEditText.getText().toString();
        String metier = metierEditText.getText().toString();
        String zoneRecherche = zoneRechercheEditText.getText().toString();
        String periode = periodeEditText.getText().toString();




        brecherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //TODO : recherche avancer pour offre

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
            Intent intent = new Intent(this, OffreActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}