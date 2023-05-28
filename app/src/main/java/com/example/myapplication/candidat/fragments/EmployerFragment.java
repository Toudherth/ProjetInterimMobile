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
import com.example.myapplication.candidat.Adapter.EmployerAdapter;
import com.example.myapplication.models.AppUser;

import java.util.ArrayList;
import java.util.List;

public class EmployerFragment extends Fragment {


    public static EmployerFragment newInstance() {
        return new EmployerFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_employer, container, false);

        ListView listView = v.findViewById(R.id.recyclerListlineeight);

        List<AppUser> employeeList = new ArrayList<>();

        AppUser employee1 = new AppUser();
        employee1.setName("John");
        employee1.setName2("Doe");
        employee1.setTel("123456789");
        employee1.setLink("https://www.example.com");

        AppUser employee2 = new AppUser();
        employee2.setName("Jane");
        employee2.setName2("Smith");
        employee2.setTel("987654321");
        employee2.setLink("https://www.example.com");

        AppUser employee3 = new AppUser();
        employee3.setName("Michael");
        employee3.setName2("Johnson");
        employee3.setTel("555555555");
        employee3.setLink("https://www.example.com");

        AppUser employee4 = new AppUser();
        employee4.setName("Emily");
        employee4.setName2("Davis");
        employee4.setTel("111111111");
        employee4.setLink("https://www.example.com");

        AppUser employee5 = new AppUser();
        employee5.setName("David");
        employee5.setName2("Wilson");
        employee5.setTel("999999999");
        employee5.setLink("https://www.example.com");

        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);

        EmployerAdapter adapter = new EmployerAdapter(getContext(), employeeList);

        listView.setAdapter(adapter);

        return v;

    }



}