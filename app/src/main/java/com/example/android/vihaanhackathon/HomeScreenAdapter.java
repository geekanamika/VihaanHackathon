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

public class HomeScreenAdapter extends RecyclerView.Adapter<HomeScreenAdapter.MyViewHolder> {

    public List<InformationModel> myList = new ArrayList<>();
    Context context;

    public HomeScreenAdapter(Context context,List<InformationModel> myList) {
        this.myList = myList;
        this.context = context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_screen_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InformationModel model = myList.get(position);
        holder.trainNo.setText(model.getTrain_no());
        holder.time.setText(model.getTime_of_accident());
        holder.accidentArea.setText(model.getReason());


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView trainNo;
        TextView time;
        TextView accidentArea;

        public MyViewHolder(View itemView) {
            super(itemView);
            trainNo = itemView.findViewById(R.id.trainNo);
            time = itemView.findViewById(R.id.timeValue);
            accidentArea = itemView.findViewById(R.id.accidentArea);
        }
    }




}
