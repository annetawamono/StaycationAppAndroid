package com.example.staycationappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class about_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}