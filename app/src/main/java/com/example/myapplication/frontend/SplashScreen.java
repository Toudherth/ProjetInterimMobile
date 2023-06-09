package com.example.myapplication.frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.frontend.Employee.Emp_LoginActivity;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 3000;

    //variables for the splash screen
    Animation topAnim, bottomAnim;
    ImageView img;
    TextView logo, tagLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        //Splash animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);


        img = findViewById(R.id.ivSplashLogo);
        logo = findViewById(R.id.tvLogo);
        tagLine = findViewById(R.id.tvTagLine);

        img.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        tagLine.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Emp_LoginActivity.class);
                //Intent intent = new Intent(SplashScreen.this,IT201333290_RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }


}