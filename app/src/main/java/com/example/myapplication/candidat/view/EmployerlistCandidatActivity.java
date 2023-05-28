package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.candidat.Adapter.EmployeeListesAdapter;
import com.example.myapplication.frontend.Employee.Emp_LatestVacancy;
import com.example.myapplication.models.AppUser;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class EmployerlistCandidatActivity extends AppCompatActivity {

    public List<AppUser> employer;
    private TextInputLayout txtrecherche;

    private ListView listView;
    private EmployeeListesAdapter adapter;
    private List<AppUser> employerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employerlist_candidat);
// menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour


        txtrecherche = findViewById(R.id.txtrecherche);

        employerlist = createEmployerList();

        // Initialisation de l'adapter avec la liste d'agences
        adapter = new EmployeeListesAdapter(this, employerlist);

        // Récupération de la ListView
        listView = findViewById(R.id.recyclerListlineeight);

        // Association de l'adapter à la ListView
        listView.setAdapter(adapter);
    }

    private List<AppUser> createEmployerList() {
        List<AppUser> employers = new ArrayList<>();

        // Adding example employers
        AppUser employer1 = new AppUser();
        employer1.setName("John");
        employer1.setName2("Doe");
        employer1.setTel("0123456789");
        employer1.setAddress("Address 1");
        employer1.setLink("https://www.example.com/employer1");
        employers.add(employer1);

        AppUser employer2 = new AppUser();
        employer2.setName("Jane");
        employer2.setName2("Smith");
        employer2.setTel("9876543210");
        employer2.setAddress("Address 2");
        employer2.setLink("https://www.example.com/employer2");
        employers.add(employer2);

        // Add more example employers if needed...

        return employers;
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
            Intent intent = new Intent(this, Emp_LatestVacancy.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}