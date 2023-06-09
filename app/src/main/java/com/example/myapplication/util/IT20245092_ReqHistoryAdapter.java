package com.example.myapplication.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.IT20224370_RequestModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class IT20245092_ReqHistoryAdapter extends FirebaseRecyclerAdapter<IT20224370_RequestModel,IT20245092_ReqHistoryAdapter.myViewHolder> {

    public IT20245092_ReqHistoryAdapter(@NonNull FirebaseRecyclerOptions<IT20224370_RequestModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull IT20224370_RequestModel model) {
        if (model.getStatus().equals("rejected") || model.getStatus().equals("accepted")) {
            holder.clientName.setText(model.getFullName());
            holder.date.setText(model.getDate());
            holder.RqName.setText(model.getSelectedJob());
            holder.location.setText(model.getAddress());
            holder.rqStatus.setText("Status - " + model.getStatus());
            holder.rqEmail.setText(model.getUserMail());
//            holder.time.setText(model.getTime());
            //!model.getStatus().equals("accepted")
        }else{
            holder.clientName.setVisibility(View.GONE);
            holder.date.setVisibility(View.GONE);
//            holder.time.setVisibility(View.GONE);
            holder.l1.setLayoutParams(holder.params);
        }
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.it20245092_requesthistory,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView clientName,date,time,RqName,location,rqStatus,rqEmail;
        LinearLayout l1;
        ViewGroup.LayoutParams params;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            clientName = (TextView) itemView.findViewById(R.id.RqName);
            date = (TextView) itemView.findViewById(R.id.rqDate);
            RqName = (TextView) itemView.findViewById(R.id.RqJName);
            location = (TextView) itemView.findViewById(R.id.rqLocation);
            rqStatus = (TextView) itemView.findViewById(R.id.rqStatus);
            rqEmail = (TextView) itemView.findViewById(R.id.RqEmail);
//            time = (TextView) itemView.findViewById(R.id.timetext);
            l1 = (LinearLayout) itemView.findViewById(R.id.hislinid);
            params = new LinearLayout.LayoutParams(0, 0);

        }
    }
}
