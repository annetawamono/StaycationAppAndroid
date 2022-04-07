package com.example.staycationappandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class listPage extends AppCompatActivity {

    private Query query;
    private AccommodationAdapter adapter;
    private RecyclerView rView;
    private TextView txtTitlePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        Utilities lUtilities = new Utilities();

        //getSupportActionBar().setTitle("Staycation App");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Intent i = getIntent();
        //String checkInDate =  i.getStringExtra("checkInDate");
        //String checkOutDate =  i.getStringExtra("checkOutDate");
        String checkInDate =  "2022-04-15";
        String checkOutDate = "2022-04-20";

        txtTitlePage = findViewById(R.id.txtTitlePage);

        //Showing the period selected before
        txtTitlePage.setText("Period: "+ lUtilities.formatDate(checkInDate) + " to " + lUtilities.formatDate(checkOutDate));

        //getting the information from DB
        //query = FirebaseDatabase.getInstance().getReference().child("accommodations");
        query = FirebaseDatabase.getInstance().getReference().child("accommodations")
                .orderByChild("availableStart")
                .startAt(checkInDate);

        FirebaseRecyclerOptions<Accommodation> options = new FirebaseRecyclerOptions.Builder<Accommodation>()
                .setQuery(query, Accommodation.class)
                .build();

        adapter = new AccommodationAdapter(options);

        rView = findViewById(R.id.rView);
        rView.setLayoutManager(new GridLayoutManager(this, 1));
        rView.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}