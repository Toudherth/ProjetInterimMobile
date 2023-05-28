package com.example.myapplication.candidat.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;


public class PostulerActivity extends AppCompatActivity {

    private TextView ttitle, tcompany,tville, ttype, tsalary, tdescription, tfamilyjob, tjoblevel, tdate;
    private Button bcandidater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postuler);
        // Menu
        Toolbar toolbar = findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Ajouter le bouton de retour

        // declaration d'attribut

        bcandidater= findViewById(R.id.btncandidater);
        ttitle= findViewById(R.id.txttitle);
        tcompany= findViewById(R.id.txtcompany);
        tville= findViewById(R.id.txtville);
        ttype= findViewById(R.id.texttype);
        tsalary= findViewById(R.id.txtsalary);
        tdescription= findViewById(R.id.txtDescription);
        tfamilyjob= findViewById(R.id.textfamily);
        tjoblevel = findViewById(R.id.txtjoblevel);
        tdate= findViewById(R.id.txtdate);

        String titre = ttitle.getText().toString();
        String company = tcompany.getText().toString();
        String ville = tville.getText().toString();
        String type = ttype.getText().toString();
        String salary = tsalary.getText().toString();
        String description = tdescription.getText().toString();
        String familyJob = tfamilyjob.getText().toString();
        String jobLevel = tjoblevel.getText().toString();
        String date = tdate.getText().toString();


        bcandidater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO
                showCandidatureTypeDialog();
             //   Intent intent= new Intent(PostulerActivity.this, CandidaterActivity.class);
               // startActivity(intent);

            }
        });

        ImageView imageShare1= findViewById(R.id.imageShare);
        imageShare1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titreOffre = "Offre spéciale";
                String descriptionOffre = "Share vacancie  !";
                partagerOffre(titreOffre, descriptionOffre);
                // int position = getAdapterPosition(); // Récupérez la position de l'offre dans la liste
                //  partagerOffreTravail(position);
            }
        });

        ImageView imageHomePage= findViewById(R.id.imageHomePage);
        imageHomePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: Save offre
                imageHomePage.setColorFilter(Color.RED);
                Toast.makeText(PostulerActivity.this, "Offer saved", Toast.LENGTH_SHORT).show();

            }
        });


    }


    // menu
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
            Intent intent = new Intent(this, OffreActivity.class);
            startActivity(intent);
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void partagerOffre(String titreOffre, String descriptionOffre) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, titreOffre);
        intent.putExtra(Intent.EXTRA_TEXT, descriptionOffre);
        startActivity(Intent.createChooser(intent, "Share this offer via"));
    }

    private int getAdapterPosition(View view) {
        RecyclerView recyclerView = (RecyclerView) view.getParent();
        RecyclerView.ViewHolder viewHolder = recyclerView.getChildViewHolder(view);
        return viewHolder.getAdapterPosition();
    }


    //TODO: pour postuler a une offre de travaille

    private void showCandidatureTypeDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose the type of application");
        builder.setItems(new CharSequence[]{"Direct application", "Application form"},
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                transmettreCandidatureDirecte();
                                break;
                            case 1:
                                ouvrirFormulaireCandidature();
                                // Formulaire de candidature
                                // Code à exécuter pour le formulaire de candidature
                                break;
                        }
                    }
                });
        builder.show();
    }


    private void transmettreCandidatureDirecte() {
        // Code pour transmettre la candidature directement
        // Par exemple, envoyer les données du candidat à un service ou une API
        // Vous pouvez utiliser des appels réseau, des requêtes HTTP, etc.

        // Afficher un message à l'utilisateur pour indiquer que la candidature a été transmise
        Toast.makeText(this, "Direct application forwarded", Toast.LENGTH_SHORT).show();
    }

    private void ouvrirFormulaireCandidature() {
        // Code pour ouvrir le formulaire de candidature
        // Par exemple, lancer une nouvelle activité qui affiche le formulaire

        // Vous pouvez utiliser Intent pour lancer l'activité du formulaire
        Intent intent = new Intent(this, CandidaterActivity.class);
        startActivity(intent);
    }


}