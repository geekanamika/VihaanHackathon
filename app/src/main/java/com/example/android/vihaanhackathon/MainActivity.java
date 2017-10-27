package com.example.android.vihaanhackathon;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<InformationModel> informationList;
    RecyclerView recyclerView;
    HomeScreenAdapter homeScreenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        informationList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        homeScreenAdapter = new HomeScreenAdapter(this,informationList);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(homeScreenAdapter);

        preapareInformationData();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void preapareInformationData() {
        ArrayList<String> passenger = new ArrayList<>();
        passenger.add("abi hackerrank");
        passenger.add("ravi sinha");
        passenger.add("puma singh");
        passenger.add("abi hackerrank");
        passenger.add("ravi sinha");
        passenger.add("puma singh");
        passenger.add("abi hackerrank");
        passenger.add("ravi sinha");
        passenger.add("puma singh");

        ArrayList<String> pnr = new ArrayList<>();
        pnr.add("102458d");
        pnr.add("458796a");
        pnr.add("102458d");
        pnr.add("458796a");
        pnr.add("102458d");
        pnr.add("458796a");
        pnr.add("102458d");
        pnr.add("458796a");
        pnr.add("102458d");


        ArrayList<String> rName = new ArrayList<>();
        rName.add("abi hackerrank");
        rName.add("ravi sinha");
        rName.add("puma singh");
        rName.add("abi hackerrank");
        rName.add("ravi sinha");
        rName.add("puma singh");
        rName.add("abi hackerrank");
        rName.add("ravi sinha");
        rName.add("puma singh");

        InformationModel model = new InformationModel("110009","16 Oct 2017","fog","Mairwa Jila","MWR",passenger,pnr,rName,10);
        informationList.add(model);
        homeScreenAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
