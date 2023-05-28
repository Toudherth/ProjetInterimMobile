package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.candidat.fragments.AgenceFragment;
import com.example.myapplication.candidat.fragments.EmployerFragment;

public class InterfanceCandidatureSpontaneActivity extends AppCompatActivity {

    private Fragment currentFragment;
    private AgenceFragment agenceFragment;
    private EmployerFragment employeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfance_candidature_spontane);

        // menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour


        Button buttonagence = findViewById(R.id.buttonagency);
        Button buttonemployer = findViewById(R.id.buttonemployer);
        agenceFragment = new AgenceFragment();
        employeFragment = new EmployerFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer, agenceFragment)
                .commit();

        buttonagence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, agenceFragment)
                        .commit();
            }
        });

        buttonemployer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, employeFragment)
                        .commit();
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