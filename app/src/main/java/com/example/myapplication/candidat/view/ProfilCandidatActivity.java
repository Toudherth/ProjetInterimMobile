package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;

public class ProfilCandidatActivity extends AppCompatActivity {

    private TextView tnom,  tmail, ttelephone, tville, tcv, tdate;
    private Toolbar toolbar ;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilcandidat);
        // Menu
        toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Declaration d'ettributs :
        tnom = findViewById(R.id.txtnom);
        tmail = findViewById(R.id.txtmail);
        tdate= findViewById(R.id.txtdate);
        ttelephone = findViewById(R.id.txttelephone);
        tville = findViewById(R.id.txtville);
         tcv = findViewById(R.id.txtcv);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         super.onCreateOptionsMenu(menu);
         getMenuInflater().inflate(R.menu.main_menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.update) {
            Intent intent = new Intent(this, UpdateCandidatActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == android.R.id.home) {
            Intent intent = new Intent(this, OffreActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.delete) {
            Intent intent = new Intent(this, AccueilCandidatActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}