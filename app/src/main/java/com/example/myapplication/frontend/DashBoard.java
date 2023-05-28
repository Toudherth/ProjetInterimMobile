package com.example.myapplication.frontend;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.frontend.Employee.Emp_CustomerMenu;
import com.example.myapplication.frontend.Employee.Emp_LoginActivity;
import com.example.myapplication.frontend.Employee.Emp_SentRequest;
import com.example.myapplication.frontend.Employee.Emp_WorkerRequest;
import com.example.myapplication.frontend.Profile.Profile_MyRequests;
import com.example.myapplication.frontend.Profile.Profile_MyReviews;
import com.example.myapplication.frontend.subscription.Subscribe;
import com.example.myapplication.R;
import com.example.myapplication.frontend.Employee.Emp_VacancyMenu;
//import com.example.hireme.frontend.it20224370.IT20224370_JobCategories;
//import com.example.hireme.frontend.it20224370.IT20224370_MyRequests;
import com.example.myapplication.frontend.Profile.Profile_workerprofile;
import com.example.myapplication.frontend.Job.IT20224370_JobCategories;
import com.example.myapplication.frontend.Job.IT20224370_Session_Management;

public class DashBoard extends AppCompatActivity {

    Button btnVacancy, btnhireWorker,btnworker,btnFeedbackID;
    String msg,name,img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dash_board);

        // Code pour ouvrir la fenêtre de dialogue directement
        SlideShowDialog slideShowDialog = new SlideShowDialog();
        slideShowDialog.show(getSupportFragmentManager(), "slide_dialog");


        btnVacancy = findViewById(R.id.btnVacancy);
        btnFeedbackID = findViewById(R.id.btnFeedbackID);

        Intent i = getIntent();
        msg = i.getStringExtra("email");
        name = i.getStringExtra("name");
        img = i.getStringExtra("img");

        System.out.println(msg);

        //set the username to a session
        IT20224370_Session_Management session;//global variable
        session = new IT20224370_Session_Management(DashBoard.this); //in oncreate
        //set sharedpreference

        session.setusename(msg); //set the usermail to the session
        session.setName(name); //set the name to the session
        session.setImg(img); //set the image to the session

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Emp_LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        ImageView homeImageView = findViewById(R.id.image_home);
        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, DashBoard.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        ImageView notifImageView = findViewById(R.id.image_notif);
        notifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Emp_WorkerRequest.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView profilImageView = findViewById(R.id.image_profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, Profile_workerprofile.class);
                startActivity(intent);
                finish();
            }
        });

    }



    public void onClick(View v){
        Intent i = new Intent();

        if(v == btnVacancy){
            i = new Intent(this, Emp_CustomerMenu.class);
            i.putExtra("email",msg);

        }

        else if(v == btnhireWorker){
            i = new Intent(this, IT20224370_JobCategories.class);
            i.putExtra("email",msg);

        }
        else if(v == btnworker) {
            i = new Intent(this, Profile_workerprofile.class);
            i.putExtra("email",msg);
            i.putExtra("name",name);
            i.putExtra("img",img);

        }else if(v == btnFeedbackID){
            i = new Intent(this, Subscribe.class);
            i.putExtra("email",msg);
            i.putExtra("name",msg);
        }


        startActivity(i);
    }

}