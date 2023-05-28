package com.example.myapplication.frontend.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.R;

public class Profile_MyJobs extends AppCompatActivity {

    ImageButton imgbtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it20245092_my_jobs);
        getSupportActionBar().hide();

        imgbtn1 = findViewById(R.id.btnaddnew);

        imgbtn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent intent = new Intent(Profile_MyJobs.this, Profile_JobDetails.class);
                startActivity(intent);
            }
            });
    }
}