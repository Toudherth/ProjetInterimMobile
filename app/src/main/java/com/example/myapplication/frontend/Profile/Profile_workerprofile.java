package com.example.myapplication.frontend.Profile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.frontend.DashBoard;
import com.example.myapplication.frontend.Employee.Emp_CustomerMenu;
import com.example.myapplication.frontend.Employee.Emp_VacancyMenu;
import com.example.myapplication.frontend.Job.IT20224370_Session_Management;

public class Profile_workerprofile extends AppCompatActivity {

     Button btn1, btn2, btn3, btn4;
     String name,email,img;
     TextView wname,wemail;
     ImageView imgview4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it20245092_workerprofile);
        getSupportActionBar().hide();


        IT20224370_Session_Management session;//global variable
        session = new IT20224370_Session_Management(Profile_workerprofile.this);
        img = session.getImg();
        name = session.getName();
        email = session.getusename();

//        Intent i = getIntent();
//        email = i.getStringExtra("email");
//        name = i.getStringExtra("name");
//        img = i.getStringExtra("img");
        System.out.println("hi" + email);
        System.out.println("haaai" + name);



        btn1 = findViewById(R.id.btnrequests);
        btn4 = findViewById(R.id.btnreviews);


        wname = (TextView) findViewById(R.id.textView2);
        wemail = (TextView) findViewById(R.id.textView3);
        imgview4 = (ImageView) findViewById(R.id.imageView4);

        wname.setText(name);
        wemail.setText(email);
        Glide.with(this).load(img).into(imgview4);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_workerprofile.this, Emp_CustomerMenu.class);
                startActivity(intent);
                finish();
            }
        });


        ImageView homeImageView = findViewById(R.id.image_home);
        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_workerprofile.this, DashBoard.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        ImageView notifImageView = findViewById(R.id.image_notif);
        notifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_workerprofile.this, DashBoard.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView profilImageView = findViewById(R.id.image_profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile_workerprofile.this, Profile_workerprofile.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void onClick(View v){
        Intent i = new Intent();

        if(v == btn1){
            i = new Intent(this, Profile_MyRequests.class);
            i.putExtra("email",email);
            i.putExtra("name",name);
        }else if(v == btn2){
//           i = new Intent(this,Jobs.class);
            i = new Intent(this, Jobs.class);
            i.putExtra("email",email);
            i.putExtra("name",name);
            i.putExtra("img",img);
        }else if(v == btn3){
            i = new Intent(this, Profile_WorkHistory.class);
            i.putExtra("email",email);
            i.putExtra("name",name);
        }else if(v == btn4){

        }

        startActivity(i);
    }
}