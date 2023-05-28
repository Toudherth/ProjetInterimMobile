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
import com.example.myapplication.candidat.view.AgenceProfilActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class CompanyAdapter  extends BaseAdapter {



    private Context context;
    private List<Agence> agenceItems;

    private LayoutInflater inflater;

    public CompanyAdapter (Context context, List<Agence> agenceItems){
        this.context= context;
        this.agenceItems = agenceItems;
        this.inflater = LayoutInflater.from(context);
    }





    @Override
    public int getCount() {
        return agenceItems.size();
    }

    @Override
    public Agence getItem(int position) {

        return agenceItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.liste_agences, null );


        // recuperation des data
        Agence currantItem = getItem(position);
        String agencename = currantItem.agencename;
        String contactnumber = currantItem.contactnumber;
        String adresse = currantItem.adresse;
        String link= currantItem.link;

        // get item name view
        TextView itemagencename= convertView.findViewById(R.id.txtagencyname);
        itemagencename.setText(agencename);
        TextView itemcontactnumber= convertView.findViewById(R.id.txttel);
        itemcontactnumber.setText(contactnumber);
        TextView itemadresse= convertView.findViewById(R.id.txtadresse);
        itemadresse.setText(adresse);
        TextView itemlink= convertView.findViewById(R.id.txtlink);
        itemlink.setText(link);
        Button boutonPostuler = convertView.findViewById(R.id.txtconsulter);

        // Ajout l'agance à l'intent
        Gson gson = new GsonBuilder().create();
        String agenceJson = gson.toJson(currantItem);

        boutonPostuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent().setClass(v.getContext(), AgenceProfilActivity.class);
                intent.putExtra("agence", agenceJson);
                context.startActivity(intent);
            }
        });



        return convertView;
    }

}


