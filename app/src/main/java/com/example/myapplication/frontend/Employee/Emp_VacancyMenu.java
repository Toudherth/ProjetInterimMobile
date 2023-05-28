package com.example.myapplication.frontend.Employee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.frontend.Profile.Profile_workerprofile;

public class Emp_VacancyMenu extends AppCompatActivity {

    Button btn1, btn2;
    String msg;
    ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancy_menu);
        getSupportActionBar().hide();
        btn1 = findViewById(R.id.btnVcustomerMenu);
        btn2 = findViewById(R.id.btnVworker);
        backArrow = findViewById(R.id.backArrow);

        Intent i = getIntent();
        msg = i.getStringExtra("email");

        //System.out.println(msg);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_VacancyMenu.this, Emp_VacancyMenu.class);
                startActivity(intent);
                finish();
            }
        });


        ImageView homeImageView = findViewById(R.id.image_home);
        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_VacancyMenu.this, Emp_VacancyMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        ImageView notifImageView = findViewById(R.id.image_notif);
        notifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_VacancyMenu.this, Emp_VacancyMenu.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView profilImageView = findViewById(R.id.image_profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_VacancyMenu.this, Profile_workerprofile.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public void onClick(View v){
        Intent i = new Intent();

        if(v == btn1)
            i = new Intent(this, Emp_CustomerMenu.class);

        else if(v == btn2)
            i = new Intent(this, Emp_JobMenu.class);

        i.putExtra("email",msg);
        startActivity(i);
    }

}