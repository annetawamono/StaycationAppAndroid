package com.example.staycationappandroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class mapview extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap androidMap;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapview);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.androidMap);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {


        androidMap = googleMap;
        LatLng current = new LatLng(Double.parseDouble(getIntent().getStringExtra("latitude")),
                Double.parseDouble(getIntent().getStringExtra("latitude")));

        androidMap.addMarker(new MarkerOptions().position(current).title(getIntent().getStringExtra("title")));

        androidMap.moveCamera(CameraUpdateFactory.newLatLng(current));
    }
}
