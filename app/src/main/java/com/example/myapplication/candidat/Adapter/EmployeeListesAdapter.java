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
import com.example.myapplication.candidat.view.AgenceProfilActivity;
import com.example.myapplication.models.AppUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class EmployeeListesAdapter  extends BaseAdapter {

    private Context context;
    private List<AppUser> employeItems;
    private LayoutInflater inflater;

    public EmployeeListesAdapter (Context context, List<AppUser> employeItems){
        this.context= context;
        this.employeItems = employeItems;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return employeItems.size();
    }

    @Override
    public AppUser getItem(int position) {

        return employeItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.liste_agences, null );


        // recuperation des data
        AppUser currantItem = getItem(position);
        String agencename = currantItem.getName();
        String agencename2 = currantItem.getName2();
        String contactnumber = currantItem.getTel2();
        String adresse = currantItem.getAddress();
        String link= currantItem.getLink();

        // get item name view
        TextView itemagencename= convertView.findViewById(R.id.txtagencyname);
        itemagencename.setText(agencename+" "+agencename2);
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




