package com.example.staycationappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Amenities extends AppCompatActivity {

    //Declaring widgets/views and adapter
    TextView txtAmenity;
    RecyclerView rview;
    ArrayList<Accommodation> img;
    AmenitiesAdapter adapter;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amenities);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Assigning recyclerview
        rview = findViewById(R.id.rview);

        //Loading amenities array
        ArrayList<String> amenities = getIntent().getExtras().getStringArrayList("amenities");
        for (String item : amenities) {
            System.out.println("Amenities");
            System.out.println(item);
        }

        //Adapter for Amenities
        LinearLayoutManager layoutManager = new LinearLayoutManager(Amenities.this, LinearLayoutManager.VERTICAL, false);
        rview.setLayoutManager(layoutManager);
        rview.setItemAnimator(new DefaultItemAnimator());

        //Setting adapter
        adapter = new AmenitiesAdapter(Amenities.this, amenities);
        rview.setAdapter(adapter);

//
//        btnBack = findViewById(R.id.btnBack);
//
//        btnBack.setOnClickListener(view -> {
//            Intent intentInfo = new Intent(Amenities.this, activity_details.class);
//
//            startActivity(intentInfo);
//
//        });
    }
}