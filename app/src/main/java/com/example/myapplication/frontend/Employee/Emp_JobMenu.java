package com.example.myapplication.frontend.Employee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.candidat.view.AccueilCandidatActivity;
import com.example.myapplication.frontend.Profile.Profile_workerprofile;

public class Emp_JobMenu extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4;
    ImageView img;
    TextView tv,tv2;
    Animation topAnim, bottomAnim;
    ImageView backArrow;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_job_menu);
        btn1 = findViewById(R.id.btnLatestV);
        img = findViewById(R.id.ivVacancyMenuImage);
        tv = findViewById(R.id.tvVacancyMenuTitle);


        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        img.setAnimation(topAnim);
        btn1.setAnimation(bottomAnim);
        tv.setAnimation(bottomAnim);


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_JobMenu.this, AccueilCandidatActivity.class);
                startActivity(intent);
                finish();
            }
        });


        ImageView homeImageView = findViewById(R.id.image_home);
        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_JobMenu.this, AccueilCandidatActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        ImageView notifImageView = findViewById(R.id.image_notif);
        notifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_JobMenu.this, AccueilCandidatActivity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView profilImageView = findViewById(R.id.image_profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_JobMenu.this, Profile_workerprofile.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void Onclick(View v){
        Intent i = new Intent(this, Emp_LatestVacancy.class);

        if(v == btn1){
            i = new Intent(this, Emp_LatestVacancy.class);
        }else if(v == btn2){
            i = new Intent(this, Emp_FindVacancy.class);
        }else if(v == btn3){
            i = new Intent(this, Emp_SentRequest.class);
        }else if(v == btn4){
            i = new Intent(this, Emp_AcceptedRequest.class);
        }

        startActivity(i);
    }

}

