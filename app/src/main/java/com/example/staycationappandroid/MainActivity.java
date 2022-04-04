package com.example.staycationappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_nextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_nextActivity = findViewById(R.id.btn_nextActivity);

        btn_nextActivity.setOnClickListener( view -> {
            //go to list page with the dates

            Intent intentDate = new Intent(MainActivity.this, listPage.class);
            intentDate.putExtra("checkInDate", "2022-01-01");
            intentDate.putExtra("checkOutDate", "2022-01-10");
            startActivity(intentDate);
        });
    }
}