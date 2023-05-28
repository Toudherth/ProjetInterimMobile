package com.example.myapplication.candidat.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.myapplication.candidat.model.Offre;

import java.util.List;

public class BaseAdapters extends BaseAdapter {


    private Context context;
    private List<Offre> offres;
    private LayoutInflater inflater;

    public BaseAdapters(){
        this.context= context;
        this.offres = offres;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return offres.size();
    }

    @Override
    public Object getItem(int position) {
        return offres.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
