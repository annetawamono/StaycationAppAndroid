package com.example.staycationappandroid;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Reserve extends AppCompatActivity {

    TextView txtSorry;
    ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve);

        txtSorry = findViewById(R.id.txtSorry);
        imageView = findViewById(R.id.underConstruction);

    }
}
