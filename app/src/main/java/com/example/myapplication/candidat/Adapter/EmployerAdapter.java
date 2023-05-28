package com.example.myapplication.candidat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.candidat.view.CandidatureSpontaneActivity;
import com.example.myapplication.models.AppUser;

import java.util.List;

public class EmployerAdapter extends BaseAdapter {


    private Context context;
    private List<AppUser> employer;
    private LayoutInflater inflater;

    public EmployerAdapter(Context context, List<AppUser> employer){
        this.context= context;
        this.employer = employer;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return employer.size();
    }

    @Override
    public AppUser getItem(int position) {
        return employer.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.item_agence, null );


        // recuperation des data
        AppUser currantItem =  getItem(position);
        String employername = currantItem.getName();
        String employerlastname = currantItem.getName2();
        String contactnumber = currantItem.getTel();
        String link= currantItem.getLink();

        // get item name view
        TextView itemagencename= convertView.findViewById(R.id.txtagencyname);
        itemagencename.setText(employername+" "+employerlastname);
        TextView itemcontactnumber= convertView.findViewById(R.id.txttel);
        itemcontactnumber.setText(contactnumber);
        TextView itemtext= convertView.findViewById(R.id.txttext);
        itemtext.setText(link);
        Button boutonPostuler = convertView.findViewById(R.id.butmessage);


        boutonPostuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent().setClass(v.getContext(), CandidatureSpontaneActivity.class);
                context.startActivity(intent);
            }
        });



        return convertView;
    }

}