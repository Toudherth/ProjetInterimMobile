package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;
import com.example.myapplication.frontend.Main_appli;

public class RolesActivity extends AppCompatActivity {

    private TextView tvconnexion, etcandidat, etemployeur, etagence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roles);
        // menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
                // Ajouter le bouton de retour
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // declaration d'attribut
        tvconnexion= findViewById(R.id.textView2);
        etcandidat = findViewById(R.id.etcandidat);
        etemployeur = findViewById(R.id.etemployeur);
        etagence = findViewById(R.id.etagence);

        TextView etAgence = findViewById(R.id.etagence);

        etAgence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etAgence.setBackgroundColor(getResources().getColor(R.color.second_color));
                        //.getColor(R.color.colorPrimary));
            }
        });


        tvconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent().setClass(RolesActivity.this, Main_appli.class);
                startActivity(intent);
            }
        });
        etcandidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent().setClass(RolesActivity.this, Candidat_LoginActivity.class);
                startActivity(intent);
            }
        });



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
            Intent intent = new Intent(this, Main_appli.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}