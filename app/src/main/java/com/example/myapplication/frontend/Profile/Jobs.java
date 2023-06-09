package com.example.myapplication.frontend.Profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.myapplication.util.IT20245092_JobAdapter;
import com.example.myapplication.models.JobsModel;
import com.example.myapplication.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Jobs extends AppCompatActivity {

    RecyclerView recyclerView;
    IT20245092_JobAdapter adapter;
    ImageButton imgbtn1;
    String email,name,img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        Intent i = getIntent();
        email = i.getStringExtra("email");
        name = i.getStringExtra("name");
        img = i.getStringExtra("img");
        System.out.println("hi" + email);
        System.out.println("haaai" + name);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));

        FirebaseRecyclerOptions<JobsModel> options =
                new FirebaseRecyclerOptions.Builder<JobsModel>()
                        .setQuery(FirebaseDatabase.getInstance("https://fir-demo-734c3-default-rtdb.firebaseio.com/")
                                .getReference().child("Jobs").orderByChild("email").equalTo(email), JobsModel.class)
                        .build();

        adapter = new IT20245092_JobAdapter(options);
        recyclerView.setAdapter(adapter);
        imgbtn1 = findViewById(R.id.btnaddnew);



    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    public void onClick(View v){
        Intent i = new Intent();

        if(v == imgbtn1){
            i = new Intent(this, Profile_JobDetails.class);
            i.putExtra("email",email);
            i.putExtra("name",name);
            i.putExtra("img",img);
        }

        startActivity(i);
    }
}