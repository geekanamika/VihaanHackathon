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

public class DetailsListReservationAdapter extends RecyclerView.Adapter<DetailsListReservationAdapter.MyReservationHolder> {
    List<String> reservationNameList = new ArrayList<>();
    List<String> pnrList = new ArrayList<>();
    Context context;

    public DetailsListReservationAdapter(List<String> reservationNameList, List<String> pnrList, Context context) {
        this.reservationNameList = reservationNameList;
        this.pnrList = pnrList;
        this.context = context;
    }

    @Override
    public MyReservationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reservation_row, parent, false);
        final DetailsListReservationAdapter.MyReservationHolder holder = new DetailsListReservationAdapter.MyReservationHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyReservationHolder holder, int position) {
        holder.reservationName.setText(reservationNameList.get(position));
        holder.pnrReservation.setText(pnrList.get(position));

    }

    @Override
    public int getItemCount() {
        return reservationNameList.size();
    }

    public class MyReservationHolder extends RecyclerView.ViewHolder {
        TextView reservationName;
        TextView pnrReservation;
        public MyReservationHolder(View itemView) {
            super(itemView);
            reservationName = itemView.findViewById(R.id.reservationName);
            pnrReservation = itemView.findViewById(R.id.resrvationPNR);
        }
    }
}
