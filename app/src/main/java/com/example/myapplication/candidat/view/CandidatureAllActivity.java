package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.candidat.Adapter.AllCandidatureAdapter;
import com.example.myapplication.candidat.model.Offre;

import java.util.ArrayList;
import java.util.List;

public class CandidatureAllActivity extends AppCompatActivity {

    private ListView offrelisteview;
    private AllCandidatureAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidature_all);

        // Menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        offrelisteview = findViewById(R.id.recyclerListlineeight);

        List<Offre> offreItems = createOffreItems();

        adapter = new AllCandidatureAdapter(this, offreItems);

        offrelisteview.setAdapter(adapter);

        offrelisteview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Logic pour gérer le clic sur un élément de la liste
                Offre selectedOffre = (Offre) parent.getItemAtPosition(position);
                Toast.makeText(CandidatureAllActivity.this, "Offre sélectionnée : " + selectedOffre.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });



    }



    // Méthode pour créer des exemples de données d'offres
    private List<Offre> createOffreItems() {
        List<Offre> offreItems = new ArrayList<>();

        Offre offre1 = new Offre();
        offre1.setTitle("Web Developer");
        offre1.setOrganization("ABC Company");
        offre1.setCite("Montpellier");
        offre1.setSalary("3000€");
        offreItems.add(offre1);

        Offre offre2 = new Offre();
        offre2.setTitle("Software Engineer");
        offre2.setOrganization("XYZ Corporation");
        offre2.setCite("Lyon");
        offre2.setSalary("2500€");
        offreItems.add(offre2);

        Offre offre4 = new Offre();
        offre4.setTitle("Développeur Web");
        offre4.setOrganization("CGI");
        offre4.setCite("Paris");
        offre4.setSalary("3000€");
        offreItems.add(offre4);

        Offre offre3 = new Offre();
        offre3.setTitle("Designer UX/UI");
        offre3.setOrganization("Entreprise B");
        offre3.setCite("Lyon");
        offre3.setSalary("2500€");
        offreItems.add(offre3);

        Offre offre5 = new Offre();
        offre5.setTitle("Data Analyst");
        offre5.setOrganization("123 Industries");
        offre5.setCite("Lyon");
        offre5.setSalary("2500€");
        offreItems.add(offre5);

        return offreItems;
    }

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