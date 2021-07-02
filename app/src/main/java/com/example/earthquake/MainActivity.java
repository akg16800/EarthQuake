package com.example.earthquake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ArrayList<Earthquake> earthquakes =new ArrayList<Earthquake>();
//        earthquakes.add(new Earthquake("7.2","San Francisco","Feb 2,2016"));
//        earthquakes.add(new Earthquake("6.1","London","Feb 2,2016"));
//        earthquakes.add(new Earthquake("3.9","Tokyo","Feb 2,2016"));
//        earthquakes.add(new Earthquake("5.4","Mexico City","Feb 2,2016"));
//        earthquakes.add(new Earthquake("2.8","Moscow","Feb 2,2016"));
//        earthquakes.add(new Earthquake("4.9","Rio de Janeiro","Feb 2,2016"));
//        earthquakes.add(new Earthquake("1.6","Paris","Feb 2,2016"));
        ArrayList<Earthquake> earthquakes=QueryUtils.extractEarthquakes();

        ListView listView=findViewById(R.id.listview);
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Earthquakes);
        final EarthQuakeAdapter adapter=new EarthQuakeAdapter(this,earthquakes);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquake currentEarthquake=adapter.getItem(position);
                Uri earthQuakeUri=Uri.parse(currentEarthquake.getmUrl());

                Intent websiteIntent=new Intent(Intent.ACTION_VIEW,earthQuakeUri);
                startActivity(websiteIntent);
            }
        });
    }
}