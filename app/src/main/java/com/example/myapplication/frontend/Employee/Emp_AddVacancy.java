package com.example.myapplication.frontend.Employee;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.frontend.Profile.Profile_workerprofile;
import com.example.myapplication.models.Vacancies;
import com.example.myapplication.services.it20133290.VacancyServicesImp;

public class Emp_AddVacancy extends AppCompatActivity {

    EditText jobTitle, organization, salary, description;
    DatePicker deadline;
    Button submit;
    String msg;
    Vacancies vacancies;
    //DatabaseReference ref;
    VacancyServicesImp vacSer = new VacancyServicesImp();

    //job family
    String item[] = {"Banking","Driving","Computer science","Developpement","Marketing","Internet","Private", "Government", "Other"};
    AutoCompleteTextView atJobFamily;
    ArrayAdapter<String> adapter;

    //job level
    String item2[] = {"Entry-level","Intermediate","Mid-level","Senior", "Executive-level"};
    AutoCompleteTextView atJobLevel;
    ArrayAdapter<String> adapter2;


    ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_vacancy);

        //assign view into variables
        jobTitle = findViewById(R.id.etJobTitle);
        //jobFamily = findViewById(R.id.etJobFamily);
        //jobLevel = (findViewById(R.id.etJobLevel));
        organization = (findViewById(R.id.etOrganization));
        salary = (findViewById(R.id.etSalary));
        description = (findViewById(R.id.etDescription));
        deadline = (findViewById(R.id.dpDeadline));
        submit = (findViewById(R.id.btnAddData));

        backArrow = findViewById(R.id.backArrow);

        ///Job family dropdown menu
        atJobFamily = findViewById(R.id.etJobFamily);
        adapter = new ArrayAdapter<String>(this,R.layout.it20133290_list_item,item);
        atJobFamily.setAdapter(adapter);
        atJobFamily.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String item = Long.toString(parent.getItemIdAtPosition(position));

                  Toast.makeText(getApplicationContext(),"Item "+item, Toast.LENGTH_SHORT);
            }
        });

        //Job level dropdown menu
        atJobLevel = findViewById(R.id.etJobLevel);
        adapter2 = new ArrayAdapter<String>(this,R.layout.it20133290_list_item,item2);
        atJobLevel.setAdapter(adapter2);
        atJobLevel.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item2 = Long.toString(parent.getItemIdAtPosition(position));

                Toast.makeText(getApplicationContext(),"Item "+item2, Toast.LENGTH_SHORT);
            }
        });



        //getExtra
        Intent i = getIntent();
        msg = i.getStringExtra("email");
        System.out.println(msg);



        //create onclick to save data
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String date = ""+deadline.getYear()+"/"+deadline.getMonth()+"/"+deadline.getDayOfMonth();

                //add values
                vacSer.addNewVacancy(Emp_AddVacancy.this,jobTitle, organization, atJobFamily,
                        atJobLevel, description,salary, date,msg) ;



            }
        });


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_AddVacancy.this, Emp_CustomerMenu.class);
                startActivity(intent);
                finish();
            }
        });


        ImageView homeImageView = findViewById(R.id.image_home);
        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_AddVacancy.this, Emp_VacancyMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        ImageView notifImageView = findViewById(R.id.image_notif);
        notifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_AddVacancy.this, Emp_VacancyMenu.class);
                startActivity(intent);
                finish();
            }
        });

        ImageView profilImageView = findViewById(R.id.image_profil);
        profilImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emp_AddVacancy.this, Profile_workerprofile.class);
                startActivity(intent);
                finish();
            }
        });


    }




}

