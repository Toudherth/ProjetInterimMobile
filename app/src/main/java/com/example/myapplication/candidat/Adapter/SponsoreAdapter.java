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
import com.example.myapplication.candidat.model.Agence;
import com.example.myapplication.candidat.view.CandidatureSpontaneActivity;

import java.util.List;

public class SponsoreAdapter extends BaseAdapter {


    private Context context;
    private List<Agence> agence;
    private LayoutInflater inflater;

    public SponsoreAdapter(Context context, List<Agence> agence){
        this.context= context;
        this.agence = agence;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return agence.size();
    }

    @Override
    public Agence getItem(int position) {
        return agence.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.item_agence, null );


        // recuperation des data
        Agence currantItem =  getItem(position);
        String agencename = currantItem.agencename;
        String contactnumber = currantItem.contactnumber;
        String adresse = currantItem.adresse;
        String link= currantItem.link;

        // get item name view
        TextView itemagencename= convertView.findViewById(R.id.txtagencyname);
        itemagencename.setText(agencename);
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


