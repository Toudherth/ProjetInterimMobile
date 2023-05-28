package com.example.myapplication.frontend.subscription;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.frontend.CardPaymentHandler;
import com.example.myapplication.frontend.DashBoard;
import com.example.myapplication.frontend.Employee.Emp_LoginActivity;
import com.example.myapplication.frontend.Employee.Emp_VacancyMenu;
import com.example.myapplication.frontend.Job.IT20224370_JobCategories;
import com.example.myapplication.frontend.Job.IT20224370_Session_Management;
import com.example.myapplication.frontend.Profile.Profile_workerprofile;
import com.example.myapplication.frontend.SlideShowDialog;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Subscribe extends AppCompatActivity {

    String msg,name,img;

    Button btnVacancy,btnVacancy2,btnVacancy3,btnVacancy4,btnVacancy5;
    String buttonText,buttonText2,buttonText3,buttonText4,buttonText5;
    SpannableString spannableString,spannableString2,spannableString3,spannableString4,spannableString5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_subscribe_view);

        btnVacancy = findViewById(R.id.btnVacancy);
        buttonText = "See more";
        spannableString = new SpannableString(buttonText);
        spannableString.setSpan(new UnderlineSpan(), 0, buttonText.length(), 0);
        btnVacancy.setText(spannableString);

        btnVacancy2 = findViewById(R.id.btnVacancy2);
        buttonText2 = "See more";
        spannableString2 = new SpannableString(buttonText2);
        spannableString2.setSpan(new UnderlineSpan(), 0, buttonText2.length(), 0);
        btnVacancy2.setText(spannableString2);

        btnVacancy3 = findViewById(R.id.btnVacancy3);
        buttonText3 = "See more";
        spannableString3 = new SpannableString(buttonText3);
        spannableString3.setSpan(new UnderlineSpan(), 0, buttonText3.length(), 0);
        btnVacancy3.setText(spannableString3);

        btnVacancy4 = findViewById(R.id.btnVacancy4);
        buttonText4 = "See more";
        spannableString4 = new SpannableString(buttonText4);
        spannableString4.setSpan(new UnderlineSpan(), 0, buttonText4.length(), 0);
        btnVacancy4.setText(spannableString4);

        btnVacancy5 = findViewById(R.id.btnVacancy5);
        buttonText5 = "See more";
        spannableString5 = new SpannableString(buttonText5);
        spannableString5.setSpan(new UnderlineSpan(), 0, buttonText5.length(), 0);
        btnVacancy5.setText(spannableString5);

        Intent i = getIntent();
        msg = i.getStringExtra("email");
        name = i.getStringExtra("name");
        img = i.getStringExtra("img");

        System.out.println(msg);

        //set the username to a session
        IT20224370_Session_Management session;//global variable
        session = new IT20224370_Session_Management(Subscribe.this); //in oncreate
        //set sharedpreference

       // session.setusename(msg); //set the usermail to the session
        //session.setName(name); //set the name to the session
        //session.setImg(img); //set the image to the session

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subscribe.this, DashBoard.class);
                startActivity(intent);
                finish();
            }
        });


        ImageView homeImageView = findViewById(R.id.image_home);
        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subscribe.this, DashBoard.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        ImageView notifImageView = findViewById(R.id.image_notif);
        notifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subscribe.this, Emp_VacancyMenu.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView profilImageView = findViewById(R.id.image_profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Subscribe.this, Profile_workerprofile.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnVacancy) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Subscribe.this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.custom_dialog, null);

            // Récupérer les éléments de la boîte de dialogue
            TextView textView = dialogView.findViewById(R.id.dialogText);
            ImageView imageView = dialogView.findViewById(R.id.dialogImage);
            Button button = dialogView.findViewById(R.id.dialogButton);

            builder.setView(dialogView);

            AlertDialog dialog = builder.create();

            // Définir le fond de la fenêtre de dialogue en blanc
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

            // Définir le clic du bouton de la boîte de dialogue
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Redirection vers une autre activité
                    Intent intent = new Intent(Subscribe.this, CardPaymentHandler.class);
                    startActivity(intent);
                    dialog.dismiss(); // Fermer la boîte de dialogue
                }
            });

            // Afficher la boîte de dialogue
            dialog.show();
        }
        else if (v.getId() == R.id.btnVacancy2) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Subscribe.this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.custom_dialog2, null);

            // Récupérer les éléments de la boîte de dialogue
            Button button = dialogView.findViewById(R.id.dialogButton);

            builder.setView(dialogView);

            AlertDialog dialog = builder.create();

            // Définir le fond de la fenêtre de dialogue en blanc
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

            // Définir le clic du bouton de la boîte de dialogue
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Redirection vers une autre activité
                    Intent intent = new Intent(Subscribe.this, CardPaymentHandler.class);
                    startActivity(intent);
                    dialog.dismiss(); // Fermer la boîte de dialogue
                }
            });

            // Afficher la boîte de dialogue
            dialog.show();
        }
        else if (v.getId() == R.id.btnVacancy3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Subscribe.this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.custom_dialog3, null);

            // Récupérer les éléments de la boîte de dialogue
            Button button = dialogView.findViewById(R.id.dialogButton);

            builder.setView(dialogView);

            AlertDialog dialog = builder.create();

            // Définir le fond de la fenêtre de dialogue en blanc
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

            // Définir le clic du bouton de la boîte de dialogue
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Redirection vers une autre activité
                    Intent intent = new Intent(Subscribe.this, CardPaymentHandler.class);
                    startActivity(intent);
                    dialog.dismiss(); // Fermer la boîte de dialogue
                }
            });

            // Afficher la boîte de dialogue
            dialog.show();
        }
        else if (v.getId() == R.id.btnVacancy4) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Subscribe.this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.custom_dialog4, null);

            // Récupérer les éléments de la boîte de dialogue
            Button button = dialogView.findViewById(R.id.dialogButton);

            builder.setView(dialogView);

            AlertDialog dialog = builder.create();

            // Définir le fond de la fenêtre de dialogue en blanc
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

            // Définir le clic du bouton de la boîte de dialogue
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Redirection vers une autre activité
                    Intent intent = new Intent(Subscribe.this, CardPaymentHandler.class);
                    startActivity(intent);
                    dialog.dismiss(); // Fermer la boîte de dialogue
                }
            });

            // Afficher la boîte de dialogue
            dialog.show();
        }
        else if (v.getId() == R.id.btnVacancy5) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Subscribe.this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.custom_dialog5, null);

            // Récupérer les éléments de la boîte de dialogue
            Button button = dialogView.findViewById(R.id.dialogButton);

            builder.setView(dialogView);

            AlertDialog dialog = builder.create();

            // Définir le fond de la fenêtre de dialogue en blanc
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

            // Définir le clic du bouton de la boîte de dialogue
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Redirection vers une autre activité
                    Intent intent = new Intent(Subscribe.this, CardPaymentHandler.class);
                    startActivity(intent);
                    dialog.dismiss(); // Fermer la boîte de dialogue
                }
            });

            // Afficher la boîte de dialogue
            dialog.show();
        }



    }




}