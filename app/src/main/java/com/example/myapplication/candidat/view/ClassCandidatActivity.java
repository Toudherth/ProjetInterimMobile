package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.myapplication.R;


public class ClassCandidatActivity extends AppCompatActivity {

    private CardView agencyCardView;
    private CardView employeeCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_candidat);

        // menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour

        agencyCardView = findViewById(R.id.agencyCardView);
        employeeCardView = findViewById(R.id.employerCardView);

        agencyCardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ClassCandidatActivity.this, CompanysActivity.class);
                startActivity(intent);
            }
        });

        employeeCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(ClassCandidatActivity.this, EmployerlistCandidatActivity.class);
                startActivity(intent);
              }
        });
    }

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
            Intent intent = new Intent(this, GestionCandidatureActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}