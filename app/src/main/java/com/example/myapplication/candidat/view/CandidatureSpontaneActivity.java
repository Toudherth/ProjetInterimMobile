package com.example.myapplication.candidat.view;

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
import com.example.myapplication.frontend.Employee.Emp_LatestVacancy;

public class CandidatureSpontaneActivity extends AppCompatActivity {

    private EditText nomEditText;
    private EditText prenomEditText;
    private EditText emailEditText;
    private EditText telEditText;
    private EditText metierEditText;
    private EditText timeEditText;
    private CheckBox cdiCheckBox;
    private CheckBox cddCheckBox;
    private CheckBox alternanceCheckBox;
    private CheckBox stageCheckBox;
    private Button soumettreButton;
    private Button annulerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidaturespontane);

        // menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour


        // Récupérer les références des vues
        nomEditText = findViewById(R.id.txtnom);
        prenomEditText = findViewById(R.id.txtPrenom);
        emailEditText = findViewById(R.id.txtemail);
        telEditText = findViewById(R.id.txttel);
        metierEditText = findViewById(R.id.txtmetier);
        timeEditText = findViewById(R.id.txttime);
        cdiCheckBox = findViewById(R.id.etcdi);
        cddCheckBox = findViewById(R.id.etcdd);
        alternanceCheckBox = findViewById(R.id.etalternance);
        stageCheckBox = findViewById(R.id.etstage);
        soumettreButton = findViewById(R.id.buttonSoumettre);
        annulerButton = findViewById(R.id.buttonannuler);

        // Récupérer les valeurs des champs de texte
        String nom = nomEditText.getText().toString();
        String prenom = prenomEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String tel = telEditText.getText().toString();
        String metier = metierEditText.getText().toString();
        String time = timeEditText.getText().toString();

        // Récupérer l'état des cases à cocher
        boolean isCdiSelected = cdiCheckBox.isChecked();
        boolean isCddSelected = cddCheckBox.isChecked();
        boolean isAlternanceSelected = alternanceCheckBox.isChecked();
        boolean isStageSelected = stageCheckBox.isChecked();

        //TODO: Envoyer une candidature spontané
        soumettreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });




        annulerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Réinitialiser les champs de texte et les cases à cocher
                nomEditText.setText("");
                prenomEditText.setText("");
                emailEditText.setText("");
                telEditText.setText("");
                metierEditText.setText("");
                timeEditText.setText("");
                cdiCheckBox.setChecked(false);
                cddCheckBox.setChecked(false);
                alternanceCheckBox.setChecked(false);
                stageCheckBox.setChecked(false);
            }
        });



    }


    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu4, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // Action à réaliser lorsque le bouton de retour est cliqué
            Intent intent = new Intent(this, Emp_LatestVacancy.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}