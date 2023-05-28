package com.example.myapplication.candidat.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.myapplication.R;
import com.example.myapplication.candidat.Adapter.CandidatureAccepterAdapter;
import com.example.myapplication.candidat.model.Offre;
import com.example.myapplication.candidat.view.CandidatureAcueilActivity;

import java.util.ArrayList;
import java.util.List;

public class AccepteCandidatureActivity extends AppCompatActivity {

    private ListView offrelisteview;
    private CandidatureAccepterAdapter adapter;

    private static final int REQUEST_CALL_PERMISSION = 1;
    private String phoneNumber = "1234567890"; // Numéro de téléphone à appeler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accepte_candidature);



        // Menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        offrelisteview = findViewById(R.id.recyclerListlineeight);

        List<Offre> offreItems = createOffreItems();

        adapter = new CandidatureAccepterAdapter(this, offreItems);

        offrelisteview.setAdapter(adapter);

        offrelisteview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Logic pour gérer le clic sur un élément de la liste
                Offre selectedOffre = (Offre) parent.getItemAtPosition(position);
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

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Gérer les actions du menu contextuel
        switch (item.getItemId()) {
            case R.id.menu_accept:
                Toast.makeText(this, "Accept", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_refuse:
                Toast.makeText(this, "Refuse", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_contact:
                Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show();

                String phoneNumber = "0123456789"; // Numéro de téléphone à appeler

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + phoneNumber));

// Vérifier si la permission CALL_PHONE est accordée
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
                    // Permission accordée, lancer l'appel
                    startActivity(intent);
                } else {
                    // Demander la permission à l'utilisateur
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PERMISSION);
                }
                return true;
            case R.id.menu_report:
                Toast.makeText(this, "Report", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_add_to_calendar:
                Toast.makeText(this, "Add to Calendar", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}