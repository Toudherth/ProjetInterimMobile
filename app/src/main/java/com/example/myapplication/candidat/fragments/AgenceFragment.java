package com.example.myapplication.candidat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.candidat.Adapter.SponsoreAdapter;
import com.example.myapplication.candidat.model.Agence;

import java.util.ArrayList;
import java.util.List;

public class AgenceFragment extends Fragment {



    public static AgenceFragment newInstance() {
        return new AgenceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_agence, container, false);

        List<Agence> agences = new ArrayList<>();

        ListView listView = v.findViewById(R.id.recyclerListlineeight);

        Agence agence1 = new Agence();
        agence1.setAgencename("ABC Recruitment Agency");
        agence1.setContactnumber("+1 123-456-7890");
        agence1.setLink("www.abcagency.com");
        agences.add(agence1);


        Agence agence2 = new Agence();
        agence2.setAgencename("XYZ Staffing Solutions");
        agence2.setContactnumber("+1 987-654-3210");
        agence2.setLink("www.xyzstaffing.com");
        agences.add(agence2);


        Agence agence3 = new Agence();
        agence3.setAgencename("Global Talent Consultants");
        agence3.setContactnumber("+1 555-123-4567");
        agence3.setLink("www.globaltalent.com");
        agences.add(agence3);

        SponsoreAdapter adapter = new SponsoreAdapter(getContext(), agences);

        listView.setAdapter(adapter);

        return v;
    }


}