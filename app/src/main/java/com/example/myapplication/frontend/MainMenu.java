package com.example.myapplication.frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MainMenu extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        button=(Button)findViewById(R.id.btn_Customer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent launchactivity= new Intent(MainMenu.this,IT20224370_JobCategories.class);
                //startActivity(launchactivity);

            }
        });

    }


}