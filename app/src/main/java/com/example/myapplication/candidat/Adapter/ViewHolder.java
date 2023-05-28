package com.example.myapplication.candidat.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView messageTextView;

    ViewHolder(View itemView) {
        super(itemView);
        // Assurez-vous de faire référence à l'ID correct du TextView en fonction de votre mise en page
        messageTextView = itemView.findViewById(R.id.sentMessageTextView);
    }
}
