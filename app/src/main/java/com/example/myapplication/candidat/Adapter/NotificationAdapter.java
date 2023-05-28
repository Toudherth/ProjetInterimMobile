package com.example.myapplication.candidat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.candidat.model.Notification;

import java.util.List;

public class NotificationAdapter extends BaseAdapter {


    private Context context;
    private List<Notification> notification;
    private LayoutInflater inflater;

    public NotificationAdapter(Context context, List<Notification> notification){
        this.context= context;
        this.notification = notification;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return notification.size();
    }

    @Override
    public Notification getItem(int position) {
        return notification.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_notification, null);

        // Récupération des données de la notification
        Notification currentItem = getItem(position);
        String titre = currentItem.getTitre();
        String message = currentItem.getMessage();
        String date= currentItem.getDate();

        // Récupération des vues de l'élément de liste
        TextView itemTitre = convertView.findViewById(R.id.txttitre);
        itemTitre.setText(titre);
        TextView itemMessage = convertView.findViewById(R.id.txtmessage);
        itemMessage.setText(message);
        TextView itemDate = convertView.findViewById(R.id.notificationDateTime);
        itemDate.setText(date);
        Button boutonPostuler = convertView.findViewById(R.id.baction);

        // Ajout de l'action du bouton
        boutonPostuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Action à effectuer lors du clic sur le bouton
            }
        });

        return convertView;
    }

}
