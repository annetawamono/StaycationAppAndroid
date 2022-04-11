package com.example.staycationappandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class activity_details extends AppCompatActivity {

    //setting views and widgets
   SliderView sliderView;
   TextView txtName;
   TextView txtAddress;
   TextView txtInfo;
   TextView txtHostName;
   Button btnAmenities;
   TextView txtAdults;
   TextView txtChildren;
   TextView txtPriceDetail;
   ImageView mapView;
   Button btnReserve;
   TextView txtmap;

    int[] images = {R.drawable.picone,
            R.drawable.pictwo,
            R.drawable.picthree,
            R.drawable.picfour,
            R.drawable.picfive
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Connecting XML widgets to class
        sliderView = findViewById(R.id.sliderView);
        txtName = findViewById(R.id.txtName);
        txtAddress = findViewById(R.id.txtAddress);
        txtInfo = findViewById(R.id.txtInfo);
        txtHostName = findViewById(R.id.OwnerName);
        btnAmenities = findViewById(R.id.btnAmenities);
        txtAdults = findViewById(R.id.txtAdults);
        txtChildren = findViewById(R.id.txtChildren);
        txtPriceDetail = findViewById(R.id.txtPriceDetail);
        btnReserve = findViewById(R.id.btnReserve);
        txtmap = findViewById(R.id.txtMaptext);


        //Collecting data from previous activity with Intent.
        txtName.setText(getIntent().getStringExtra("title"));
        txtPriceDetail.setText("C$ " + getIntent().getStringExtra("price"));
        txtInfo.setText(getIntent().getStringExtra("info"));
        txtHostName.setText(getIntent().getStringExtra("ownerName"));
        txtAddress.setText(getIntent().getStringExtra("Address"));
        //().getStringExtra("image");




        //creating adapter object
        SliderAdapter sliderAdapter = new SliderAdapter(images);

        //setting adapter to slider view
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        //sliderView.startAutoCycle();

        txtmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_details.this,mapview.class);
                intent.putExtra("longitude",getIntent().getStringExtra("longitude"));
                intent.putExtra("latitude",getIntent().getStringExtra("latitude"));
                intent.putExtra("title",getIntent().getStringExtra("title"));
                startActivity(intent);
            }
        });

        btnAmenities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(activity_details.this,Reserve.class);
                startActivity(intent1);
            }
        });

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_details.this,Reserve.class);
                startActivity(intent);
            }
        });

    }
}