package com.example.myapplication.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.frontend.Agence.Agence_LoginActivity;
import com.example.myapplication.candidat.view.Candidat_LoginActivity;
import com.example.myapplication.frontend.Employee.Emp_LoginActivity;
import com.example.myapplication.services.it20133290.VacancyServicesImp;
import com.google.firebase.auth.FirebaseAuth;

public class Main_appli extends AppCompatActivity {


    Button employer,candidat,agency;
    private FirebaseAuth auth;
    VacancyServicesImp vacSer = new VacancyServicesImp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_apli);
        getSupportActionBar().hide();


        employer = findViewById(R.id.btnEmployee);
        candidat = findViewById(R.id.btnCandidat);
        agency = findViewById(R.id.btnAgency);

        employer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i  = new Intent(Main_appli.this, Emp_LoginActivity.class);
                startActivity(i);
            }
        });

        candidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(Main_appli.this, Candidat_LoginActivity.class);
                startActivity(i);
            }
        });

        agency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  = new Intent(Main_appli.this, Agence_LoginActivity.class);
                startActivity(i);
            }
        });



    }
}