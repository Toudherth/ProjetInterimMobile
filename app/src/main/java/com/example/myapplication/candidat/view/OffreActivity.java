package com.example.myapplication.candidat.view;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.candidat.Adapter.OffreAdapterItems;
import com.example.myapplication.candidat.model.Offre;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class OffreActivity extends AppCompatActivity{
    ArrayList<String> text;
    private static final String TAG= "MainActivity";
    private static final int RESULT_SPEECH = 1;
    private ImageButton  brecherche, brechvocale;
    private TextInputLayout txtrecherche;
    private ListView offrelisteview;
    private OffreAdapterItems adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offre);
        // Menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        brecherche = findViewById(R.id.searchnormal);
        brechvocale = findViewById(R.id.searchvocal);
        txtrecherche = findViewById(R.id.txtrecherche);

        offrelisteview = findViewById(R.id.recyclerListlineeight);

        List<Offre> offreItems = createOffreItems();

        adapter = new OffreAdapterItems(this, offreItems);

        offrelisteview.setAdapter(adapter);

        offrelisteview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Logic pour gérer le clic sur un élément de la liste
                Offre selectedOffre = (Offre) parent.getItemAtPosition(position);
                Toast.makeText(OffreActivity.this, "Offre sélectionnée : " + selectedOffre.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });


        brechvocale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Option de recherche vocale
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now...");
                try {
                    startActivityForResult(intent, RESULT_SPEECH);
                } catch (ActivityNotFoundException e) {
                    // Gérer l'erreur si la recherche vocale n'est pas prise en charge sur cet appareil
                    Toast.makeText(OffreActivity.this, "Vocal faild", Toast.LENGTH_SHORT).show();
                }
            }
        });

        brecherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        // operation sur l'interface de layout
        offrelisteview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent().setClass(OffreActivity.this, com.example.myapplication.candidat.view.PostulerActivity.class);
                startActivity(intent);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;

        switch (id) {
            case R.id.bprofilcandidat: // recherche avance
                intent = new Intent(this, com.example.myapplication.candidat.view.ProfilCandidatActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.itemsearchavancer: // recherche avance
                intent = new Intent(this, com.example.myapplication.candidat.view.RechercheaActivity.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.itemsauvgarder:

                intent = new Intent(this, com.example.myapplication.candidat.view.SaveoffreActivity.class);
                startActivity(intent);
                return true;

            case R.id.itemquit:
                finish();
                return true;

            case R.id.itemdeconnexion:

                //TODO: Deconnexion
                return true;
            case android.R.id.home:
                    // Action à réaliser lorsque le bouton de retour est cliqué
                    intent = new Intent(this, AccueilCandidatActivity.class);
                    startActivity(intent);
                    return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case RESULT_SPEECH:
                if(resultCode == RESULT_OK && data != null){
                    text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    System.out.println(text.get(0));
                    txtrecherche.getEditText().setText(text.get(0));
                }
                break;
        }
    }



}