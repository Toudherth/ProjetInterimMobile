package com.example.myapplication.frontend.Employee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.database.Connection;
import com.example.myapplication.frontend.DashBoard;
import com.example.myapplication.frontend.Profile.Profile_workerprofile;
import com.example.myapplication.models.Vacancies;
import com.example.myapplication.util.Common.VacancyPublishedAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class Emp_PublishedVacancy extends AppCompatActivity {

    VacancyPublishedAdapter vpa;
    RecyclerView recyclerView;
    Connection con =  new Connection();
    String msg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_published_vacancy);
        getSupportActionBar().hide();

        Intent i = getIntent();
        msg = i.getStringExtra("email");
        System.out.println(msg);

        recyclerView = (RecyclerView)findViewById(R.id.rvUpdateVacancy);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Vacancies> options = new FirebaseRecyclerOptions.Builder<Vacancies>().
                setQuery(con.getRef().child("Vacancies").orderByChild("email").equalTo(msg),Vacancies.class).build();

        vpa = new VacancyPublishedAdapter(options);
        recyclerView.setAdapter(vpa);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_PublishedVacancy.this, Emp_CustomerMenu.class);
                startActivity(intent);
                finish();
            }
        });


        ImageView homeImageView = findViewById(R.id.image_home);
        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_PublishedVacancy.this, DashBoard.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        ImageView notifImageView = findViewById(R.id.image_notif);
        notifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_PublishedVacancy.this, DashBoard.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView profilImageView = findViewById(R.id.image_profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_PublishedVacancy.this, Profile_workerprofile.class);
                startActivity(intent);
                finish();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        vpa.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        vpa.stopListening();
    }
}