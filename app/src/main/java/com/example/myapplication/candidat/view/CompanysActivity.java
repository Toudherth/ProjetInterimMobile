package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.candidat.Adapter.CompanyAdapter;
import com.example.myapplication.candidat.model.Agence;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class CompanysActivity extends AppCompatActivity {


    ArrayList<String> text;
    private static final String TAG= "MainActivity";
    public List<Agence> agences;
    private static final int RESULT_SPEECH = 1;
    private ImageButton brecherche, brechvocale;
    private TextInputLayout txtrecherche;

    private ListView listView;
    private CompanyAdapter adapter;
    private List<Agence> agenceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companys);

        // Menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour
        // declaration attribut
        brecherche = findViewById(R.id.searchnormal);
        brechvocale = findViewById(R.id.searchvocal);
        txtrecherche = findViewById(R.id.txtrecherche);

        agenceList = createAgenceList();

        // Initialisation de l'adapter avec la liste d'agences
        adapter = new CompanyAdapter(this, agenceList);

        // Récupération de la ListView
        listView = findViewById(R.id.recyclerListlineeight);

        // Association de l'adapter à la ListView
        listView.setAdapter(adapter);
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
        if (id == android.R.id.home) {
            // Action à réaliser lorsque le bouton de retour est cliqué
            Intent intent = new Intent(this, OffreActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
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


    private List<Agence> createAgenceList() {
        List<Agence> agences = new ArrayList<>();

        // Ajout d'exemples d'agences
        Agence agence1 = new Agence();
        agence1.setAgencename("Agence 1");
        agence1.setContactnumber("0123456789");
        agence1.setAdresse("Adresse 1");
        agence1.setLink("https://www.example.com/agence1");
        agences.add(agence1);

        Agence agence2 = new Agence();
        agence2.setAgencename("Agence 2");
        agence2.setContactnumber("9876543210");
        agence2.setAdresse("Adresse 2");
        agence2.setLink("https://www.example.com/agence2");
        agences.add(agence2);

        // Ajoutez plus d'exemples d'agences si nécessaire...

        return agences;
    }

}