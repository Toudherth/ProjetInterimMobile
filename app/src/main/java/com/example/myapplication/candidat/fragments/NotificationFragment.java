package com.example.myapplication.candidat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.candidat.Adapter.NotificationAdapter;
import com.example.myapplication.candidat.model.Notification;

import java.util.ArrayList;
import java.util.List;


public class NotificationFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_notification, container, false);

            // Récupérer la ListView à partir de la vue du fragment
            ListView listView = view.findViewById(R.id.recyclerListlineeight);

        List<Notification> responseNotifications = new ArrayList<>();

// Response 1
        Notification response1 = new Notification();
        response1.setTitre("Response to your application");
        response1.setMessage("We are pleased to inform you that your application has been accepted.");
        response1.setDate("28/05/2023");
        responseNotifications.add(response1);

// Response 2
        Notification response2 = new Notification();
        response2.setTitre("Response to your application");
        response2.setMessage("We regret to inform you that your application has not been accepted.");
        response2.setDate("12/05/2023");
        responseNotifications.add(response2);

// Response 3
        Notification response3 = new Notification();
        response3.setTitre("Response to your application");
        response3.setMessage("Your application is currently under review. We will notify you soon.");
        response3.setDate("10/05/2023");
        responseNotifications.add(response3);

// Response 4
        Notification response4 = new Notification();
        response4.setTitre("Response to your application");
        response4.setMessage("Congratulations! You have been shortlisted for the next round of interviews.");
        response4.setDate("01/05/2023");
        responseNotifications.add(response4);

// Response 5
        Notification response5 = new Notification();
        response5.setTitre("Response to your application");
        response5.setMessage("Thank you for your interest. We have filled the position with another candidate.");
        response5.setDate("25/04/2023");
        responseNotifications.add(response5);

// Use the responseNotifications list wherever you need, such as displaying them in a list or storing them in a database




        NotificationAdapter adapter = new NotificationAdapter(getActivity(), responseNotifications);

            // Définir l'adaptateur sur la ListView
            listView.setAdapter(adapter);

            // Ajouter des actions supplémentaires selon tes besoins

            return view;
        }


}