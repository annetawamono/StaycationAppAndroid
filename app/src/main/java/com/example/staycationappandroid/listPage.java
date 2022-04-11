package com.example.staycationappandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class listPage extends AppCompatActivity {

    private Query query, query2;
    private AccommodationAdapter adapter;
    private RecyclerView rView;
    private TextView txtTitlePage, txtNuGests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        Utilities lUtilities = new Utilities();

        getSupportActionBar().setTitle("Staycation App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Intent i = getIntent();
        //String checkInDate =  i.getStringExtra("checkInDate");
        //String checkOutDate =  i.getStringExtra("checkOutDate");
        //String nuGuests =  i.getStringExtra("nuGuests");
        String checkInDate =  "2022-04-15";
        String checkOutDate = "2022-04-20";
        String nuGuests = "3";

        txtTitlePage = findViewById(R.id.txtTitlePage);
        txtNuGests = findViewById(R.id.txtNuGests);

        //Showing the period selected before
        txtTitlePage.setText("From: "+ lUtilities.formatDate(checkInDate) + " to " + lUtilities.formatDate(checkOutDate));
        txtNuGests.setText(nuGuests);

        //getting the information from DB
        //query = FirebaseDatabase.getInstance().getReference().child("accommodations");
        query = FirebaseDatabase.getInstance().getReference().child("accommodations")
                .orderByChild("availableStart")
                .startAt(checkInDate);

        FirebaseRecyclerOptions<Accommodation> options = new FirebaseRecyclerOptions.Builder<Accommodation>()
                .setQuery(query, Accommodation.class)
                .build();



        /*
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot accommodationSnapshot : dataSnapshot.getChildren()) {
                    Accommodation accommodation = dataSnapshot.getValue(Accommodation.class);
                    if (accommodation.getAvailableEnd() <= checkOutDate) {
                        accommodationSnapshot.getKey();
                    }
                }
            }

         */

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