package com.example.myapplication.frontend.Profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.util.IT20245092_ReviewAdapter;

public class Profile_MyReviews extends AppCompatActivity {

    RecyclerView recyclerView;
    IT20245092_ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it20245092_my_reviews);

        recyclerView = (RecyclerView) findViewById(R.id.reviewsrv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        FirebaseRecyclerOptions<MODEL CLASS> options =
//                new FirebaseRecyclerOptions.Builder<IT20224370_RequestModel>()
//                        .setQuery(FirebaseDatabase.getInstance("https://hireme-2753d-default-rtdb.firebaseio.com/").getReference().child("requests"), IT20224370_RequestModel.class)
//                        .build();
//
//        reviewAdapter = new IT20245092_RequestAdapter(options);
//        recyclerView.setAdapter(reviewAdapter);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        reviewAdapter.startListening();
//    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        reviewAdapter.stopListening();
//    }
}