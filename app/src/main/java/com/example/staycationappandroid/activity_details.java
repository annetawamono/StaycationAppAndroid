package com.example.staycationappandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class activity_details extends AppCompatActivity {

    //setting views and widgets
   RecyclerView sliderView;
   SliderAdapter adapter;
   ArrayList<Accommodation> images ;

   TextView txtName;
   TextView txtAddress;
   TextView txtInfo;
   TextView txtHostName;
   Button btnAmenities;
   EditText txtAdults;
   EditText txtChildren;
   TextView txtPriceDetail;
   ImageView mapView;
   Button btnReserve;
   TextView txtmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Connecting/Assigning XML widgets to class
        txtName = findViewById(R.id.txtName);
        txtAddress = findViewById(R.id.txtAddress);
        txtInfo = findViewById(R.id.txtInfo);
        txtHostName = findViewById(R.id.OwnerName);
        btnAmenities = findViewById(R.id.textAmenity);
        txtAdults = findViewById(R.id.txtAdults);
        txtChildren = findViewById(R.id.txtChildren);
        txtPriceDetail = findViewById(R.id.txtPriceDetail);
        btnReserve = findViewById(R.id.btnReserve);
        txtmap = findViewById(R.id.txtMap);


        //Collecting data from previous activity with Intent.
        txtName.setText(getIntent().getStringExtra("title"));
        txtPriceDetail.setText("C$ " + getIntent().getStringExtra("price"));
        txtInfo.setText(getIntent().getStringExtra("info"));
        txtHostName.setText(getIntent().getStringExtra("ownerName"));
        txtAddress.setText(getIntent().getStringExtra("Address"));

        //Images Array
        ArrayList<String> images = getIntent().getExtras().getStringArrayList("imageURL");
        for (String item : images) {
           System.out.println("New Array");
            System.out.println(item);
        }

        //Adapter for image slider
        sliderView = findViewById(R.id.sliderView);
        //Setting horizontal linear layout for image slider
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity_details.this,LinearLayoutManager.HORIZONTAL,false);
        sliderView.setLayoutManager(layoutManager);
        sliderView.setItemAnimator(new DefaultItemAnimator());
        adapter = new SliderAdapter(images);
        sliderView.setAdapter(adapter);

        //Onclick - intent event for Google map
        txtmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Lattitude and longitude search working fine as well but the accomodations are not real hence no exact location and hence the city name search);
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + getIntent().getStringExtra("city"));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        //Onclick event - intent for Amenities display
        btnAmenities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(activity_details.this,Amenities.class);
                intent1.putExtra("amenities",getIntent().getExtras().getStringArrayList("amenities"));
                startActivity(intent1);
            }
        });

        //Onclick - intent for Reserve page
        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_details.this,Reserve.class);
                startActivity(intent);
            }
        });

    }
}