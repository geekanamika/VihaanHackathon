package com.example.android.vihaanhackathon;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<InformationModel> informationList;
    RecyclerView recyclerView;
    HomeScreenAdapter homeScreenAdapter;
    TextView resultsFromJson;
    ArrayList<InformationModel> list ;
    String tag_json_obj = "myTag";
    String url = "http://10.15.2.46:3030/trains";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        informationList = new ArrayList<>();
        list = new ArrayList<>();
        createDataInformation();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        homeScreenAdapter = new HomeScreenAdapter(this, list, new HomeScreenAdapter.ClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("Information",list.get(position));
                startActivity(intent);

            }
        });


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

    private void createDataInformation() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching Information...");
        progressDialog.show();
        Log.d("myTag", url);


        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("myTag", response.toString());
                        for ( int i =0;i<response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);

                                JSONArray namesArray = object.getJSONArray("generalNames");
                                ArrayList<String> passenger = new ArrayList<>();
                                for(int j=0;j<namesArray.length();j++){
                                    passenger.add(namesArray.getString(j));
                                }

                                ArrayList<String> rName= new ArrayList<>();
                                ArrayList<String> pnr = new ArrayList<>();
                                JSONArray reservedList = object.getJSONArray("reservedList");
                                for(int j=0;j<namesArray.length();j++){
                                    JSONObject resPas = reservedList.getJSONObject(j);
                                    rName.add(resPas.getString("name"));
                                    pnr.add(resPas.getString("pnr"));
                                }

                                InformationModel model = new InformationModel(object.getString("trainNo"),object
                                .getString("timeOfAccident"),object.getString("reason"),
                                        object.getString("district"),object.getString("stationCode"),passenger,pnr,rName,object.getInt("unknownIdentities"));

                                list.add(model);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        progressDialog.hide();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("yourTag", "Error: " + error.getMessage().toString());
                progressDialog.hide();
            }
        });
        Appcontroller.getInstance().addToRequestQueue(req, tag_json_obj);


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

        InformationModel model = new InformationModel("110009", "16 Oct 2017", "fog", "Mairwa Jila", "MWR", passenger, pnr, rName, 10);
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
