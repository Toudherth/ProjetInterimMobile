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

public class CandidatureAcueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidature_acueil);

        // menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Référence aux cardviews
        CardView candidaturesCardView = findViewById(R.id.candidaturesCardView);
        CardView candidaturespontanerCardView = findViewById(R.id.candidaturespontanerCardView);
        CardView propositionsCardView = findViewById(R.id.propositionsCardView);
        CardView reponses1CardView = findViewById(R.id.reponses1CardView);
        CardView reponsesCardView = findViewById(R.id.reponsesCardView);


        // Ajout d'un écouteur de clic sur chaque cardview
        candidaturesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CandidatureAcueilActivity.this, CandidatureAllActivity.class);
                startActivity(intent);
                finish();
            }
        });

        candidaturespontanerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CandidatureAcueilActivity.this, CandidatureAllActivity.class);
                startActivity(intent);
                finish();
            }
        });

        propositionsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CandidatureAcueilActivity.this, CandidatureFilterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        reponses1CardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CandidatureAcueilActivity.this, AccepteCandidatureActivity.class);
                startActivity(intent);
                finish();
            }
        });

        reponsesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CandidatureAcueilActivity.this, CandidatureRefuserActivity.class);
                startActivity(intent);
                finish();
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
            Intent intent = new Intent(this, GestionCandidatureActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}