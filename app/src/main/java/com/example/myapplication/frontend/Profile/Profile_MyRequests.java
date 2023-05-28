package com.example.myapplication.frontend.Profile;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.models.IT20224370_RequestModel;
import com.example.myapplication.util.IT20245092_RequestAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Profile_MyRequests extends AppCompatActivity {

    RecyclerView recyclerView;
    IT20245092_RequestAdapter requestAdapter;
    String email,name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it20245092_my_requests);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        Intent i = getIntent();
        email = i.getStringExtra("email");
        name = i.getStringExtra("name");
        System.out.println("hi" + email);
        System.out.println("haaai" + name);

        recyclerView = (RecyclerView) findViewById(R.id.requestsrv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<IT20224370_RequestModel> options =
                new FirebaseRecyclerOptions.Builder<IT20224370_RequestModel>()
                .setQuery(FirebaseDatabase.getInstance("https://interimo2-default-rtdb.firebaseio.com/")
                        .getReference().child("requests")
                        .orderByChild("mail").equalTo(email)
                        ,IT20224370_RequestModel.class)
                .build();

        requestAdapter = new IT20245092_RequestAdapter(options);
        recyclerView.setAdapter(requestAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        requestAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        requestAdapter.stopListening();
    }
}