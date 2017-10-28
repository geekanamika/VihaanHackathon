package com.example.android.vihaanhackathon;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anamika on 28/10/17.
 */

public class DetailsListGeneralAdapter extends RecyclerView.Adapter<DetailsListGeneralAdapter.MyViewGeneralAdapter> {
    List<String> generalList = new ArrayList<>();
    Context context;
    @Override
    public MyViewGeneralAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.general_row, parent, false);
        final MyViewGeneralAdapter holder = new MyViewGeneralAdapter(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewGeneralAdapter holder, int position) {
        holder.generalName.setText(generalList.get(position));
    }

    @Override
    public int getItemCount() {
        return generalList.size();
    }

    public DetailsListGeneralAdapter(List<String> generalList, Context context) {
        this.generalList = generalList;
        this.context = context;
    }

    public class MyViewGeneralAdapter extends RecyclerView.ViewHolder {
        TextView generalName;
        public MyViewGeneralAdapter(View itemView) {
            super(itemView);
            generalName = itemView.findViewById(R.id.generalrowText);
        }
    }
}
