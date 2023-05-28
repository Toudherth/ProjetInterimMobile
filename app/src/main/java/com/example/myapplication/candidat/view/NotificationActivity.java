package com.example.myapplication.candidat.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.candidat.fragments.NotificationFragment;
import com.example.myapplication.candidat.fragments.OffreFragment;

public class NotificationActivity extends AppCompatActivity {

    private Button buttonNotifications;
    private Button buttonOffres;

    // curent fragment
    private Fragment currentFragment;
    private NotificationFragment notificationFragment;
    private OffreFragment offreFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        // menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour


        Button buttonNotifications = findViewById(R.id.buttonNotifications);
        Button buttonOffres = findViewById(R.id.buttonoffre);
        FrameLayout fragmentContainer = findViewById(R.id.frameContainer);

        notificationFragment = new NotificationFragment();
        offreFragment = new OffreFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameContainer, notificationFragment)
                .commit();

        buttonNotifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, notificationFragment)
                        .commit();
            }
        });

        buttonOffres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameContainer, offreFragment)
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