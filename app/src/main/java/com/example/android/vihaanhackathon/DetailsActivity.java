package com.example.android.vihaanhackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView mainHeading;
    TextView unknownPeopleCount;
    RecyclerView safeListRecyclerView;
    DetailsListReservationAdapter detailsListReservationAdapter;

    RecyclerView generalSafeListRecyclerView;
    DetailsListGeneralAdapter detailsListGeneralAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        InformationModel model = intent.getParcelableExtra("Information");


        mainHeading = (TextView) findViewById(R.id.mainHeading);
        mainHeading.setText("Safe People List in Train number "+model.getTrain_no()+ ":");
        unknownPeopleCount = (TextView) findViewById(R.id.unknownPeoplecount);
        unknownPeopleCount.setText("Unknown People count is "+model.getUnknownIdentities());

        safeListRecyclerView = (RecyclerView) findViewById(R.id.safeListReservationDetails);
        detailsListReservationAdapter = new DetailsListReservationAdapter(model.getrName(),model.getPnr(),this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        safeListRecyclerView.setLayoutManager(mLayoutManager);
        safeListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        safeListRecyclerView.setAdapter(detailsListReservationAdapter);


        generalSafeListRecyclerView = (RecyclerView) findViewById(R.id.safeListGeneralDetails);
        detailsListGeneralAdapter = new DetailsListGeneralAdapter(model.getGeneralPassengerList(),this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        generalSafeListRecyclerView.setLayoutManager(layoutManager);
        generalSafeListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        generalSafeListRecyclerView.setAdapter(detailsListGeneralAdapter);






        Log.d("myTag",model.getDistrict()+ " reason "+model.getReason());

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}
