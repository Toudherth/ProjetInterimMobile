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
import com.example.myapplication.candidat.Adapter.OffreutilisateuranonymeAdapter;
import com.example.myapplication.candidat.model.Offre;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class OffreutilisateuranonymeActivity extends AppCompatActivity {


    private OffreutilisateuranonymeAdapter adapter;
    ArrayList<String> text;
    private static final String TAG= "MainActivity";
    private static final int RESULT_SPEECH = 1;
    private ImageButton brecherche, brechvocale;
    private TextInputLayout txtrecherche;
    private ListView offrelisteview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offreutilisateuranonyme);
        // Menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour
        // declaration attribut
        brecherche = findViewById(R.id.searchnormal);
        brechvocale = findViewById(R.id.searchvocal);
        txtrecherche = findViewById(R.id.txtrecherche);

        //Liste des offres :
        offrelisteview = findViewById(R.id.recyclerListlineeight);


        // Création des exemples de données
        List<Offre> offreItems = createOffreItems();

        // Création de l'adaptateur
        adapter = new OffreutilisateuranonymeAdapter(this, offreItems);

        // Assignation de l'adaptateur à la liste
        offrelisteview.setAdapter(adapter);

        // Opération sur l'interface de layout lorsqu'un élément est cliqué
        offrelisteview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Logic pour gérer le clic sur un élément de la liste
                Offre selectedOffre = (Offre) parent.getItemAtPosition(position);
                Toast.makeText(OffreutilisateuranonymeActivity.this, "Offre sélectionnée : " + selectedOffre.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });


        // la recherche normale
        brecherche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: ici code
            }
        });

        //recherche vocal
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
                    Toast.makeText(OffreutilisateuranonymeActivity.this, "Vocal faild", Toast.LENGTH_SHORT).show();
                }
            }
        });




        // operation sur l'interface de layout
        offrelisteview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent().setClass(OffreutilisateuranonymeActivity.this, PostulerActivity.class);
                startActivity(intent);
            }
        });



    }



    // Méthode pour créer des exemples de données d'offres
    private List<Offre> createOffreItems() {
        List<Offre> offreItems = new ArrayList<>();

        // Exemple d'offre 1
        Offre offre1 = new Offre();
        offre1.setTitle("Développeur Web");
        offre1.setOrganization("Entreprise A");
        offre1.setCite("Paris");
        offre1.setSalary("3000€");
        offreItems.add(offre1);

        // Exemple d'offre 2
        Offre offre2 = new Offre();
        offre2.setTitle("Designer UX/UI");
        offre2.setOrganization("Entreprise B");
        offre2.setCite("Lyon");
        offre2.setSalary("2500€");
        offreItems.add(offre2);

        // Ajouter d'autres exemples d'offres...

        return offreItems;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu3, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;

        switch (id) {
            case R.id.itemsearchavancer: // recherche avance
                intent = new Intent(this, RechercheaActivity.class);
                startActivity(intent);
                finish();
                return true;

            case R.id.itemsauvgarder:

                intent = new Intent(this, SaveoffreActivity.class);
                startActivity(intent);
                return true;

            case R.id.itemdeconnexion:

                intent = new Intent(this, RechercheaActivity.class);
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