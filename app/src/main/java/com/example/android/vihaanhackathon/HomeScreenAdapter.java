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
    ClickListener listener;

    public HomeScreenAdapter(Context context,List<InformationModel> myList,ClickListener listener) {
        this.myList = myList;
        this.context = context;
        this.listener = listener;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_screen_row, parent, false);
        final MyViewHolder holder = new MyViewHolder(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, holder.getAdapterPosition());
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InformationModel model = myList.get(position);
        holder.trainNo.setText(model.getTrain_no());
        holder.time.setText(model.getTime_of_accident());
        holder.accidentArea.setText(model.getReason());


    }

    public interface ClickListener {
        void onItemClick(View v, int position);

    }

    @Override
    public int getItemCount() {
        return myList.size();
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
