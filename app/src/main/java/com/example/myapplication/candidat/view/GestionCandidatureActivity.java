package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.myapplication.R;

public class GestionCandidatureActivity extends AppCompatActivity {

    private CardView candidaturesCardView;
    private CardView candidaturespontanerCardView;
    private CardView propositionsCardView;
    private CardView reponsesCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_candidature);

        // Find CardViews by their IDs
        candidaturesCardView = findViewById(R.id.candidaturesCardView);
        candidaturespontanerCardView = findViewById(R.id.candidaturespontanerCardView);
        propositionsCardView = findViewById(R.id.propositionsCardView);
        reponsesCardView = findViewById(R.id.reponsesCardView);

        // Set click listeners for CardViews
        candidaturesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(GestionCandidatureActivity.this, CandidatureAcueilActivity.class);
                startActivity(intent);

            }
        });

        candidaturespontanerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(GestionCandidatureActivity.this, InterfanceCandidatureSpontaneActivity.class);
                startActivity(intent);
            }
        });

        propositionsCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(GestionCandidatureActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });

        reponsesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(GestionCandidatureActivity.this, ClassCandidatActivity.class);
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
            Intent intent = new Intent(this, CandidatureAcueilActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}