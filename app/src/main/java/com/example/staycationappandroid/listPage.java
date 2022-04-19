package com.example.staycationappandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class listPage extends AppCompatActivity {

    private Query query;
    private AccommodationAdapter adapter;
    private RecyclerView rView;
    private TextView txtTitlePage, txtNuGuests;
    private ImageView icon_guests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        Utilities lUtilities = new Utilities();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String fullDate = getIntent().getStringExtra("DATES");
        String nuGuests =  getIntent().getStringExtra("GUESTS");

        txtTitlePage = findViewById(R.id.txtTitlePage);
        txtNuGuests = findViewById(R.id.txtNuGuests);
        icon_guests = findViewById(R.id.icon_guests);

        //Showing the period selected before
        //txtTitlePage.setText("From "+ lUtilities.formatDate(checkInDate) + " to " + lUtilities.formatDate(checkOutDate));
        txtTitlePage.setText(fullDate);
        txtNuGuests.setText(nuGuests);

        //getting the information from DB
        if ("Dates not chosen" == fullDate.intern()){
            query = FirebaseDatabase.getInstance().getReference().child("accommodations");
        } else{
            String checkInDate = lUtilities.formatDate2(fullDate.substring(0,6));
            query = FirebaseDatabase.getInstance().getReference().child("accommodations")
                    .orderByChild("availableStart")
                    .startAt(checkInDate);
        }

        FirebaseRecyclerOptions<Accommodation> options = new FirebaseRecyclerOptions.Builder<Accommodation>()
                .setQuery(query, Accommodation.class)
                .build();


        adapter = new AccommodationAdapter(options);

        rView = findViewById(R.id.rView);
        rView.setLayoutManager(new GridLayoutManager(this, 1));
        rView.setAdapter(adapter);

        //to list_page
        icon_guests.setOnClickListener(view -> {
            Intent intentAbout = new Intent(listPage.this, about_page.class);
            startActivity(intentAbout);
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}


/* --> trying to do a filter in the data

        //getting the information from DB
        //query = FirebaseDatabase.getInstance().getReference().child("accommodations");

        //FirebaseRecyclerOptions<Accommodation> options = new FirebaseRecyclerOptions.Builder<Accommodation>()
        //        .setQuery(query, Accommodation.class)
        //        .build();


        FirebaseRecyclerOptions<Accommodation> options = new FirebaseRecyclerOptions.Builder<Accommodation>()
                .setQuery(query, new SnapshotParser<Accommodation>() {
                    @NonNull
                    @Override
                    public Accommodation parseSnapshot(@NonNull DataSnapshot snapshot) {
                        Accommodation originalData = snapshot.getValue(Accommodation.class);

                        Date checkInDate = new Date();
                        try {
                            checkInDate =  dateFormat.parse("2022-04-15");
                        }
                        catch (Exception e){

                        }

                        try {
                            Date date1 = dateFormat.parse(originalData.getAvailableStart());

                            if (date1.compareTo(checkInDate) < 0 ) {
                                arrayOfAccommodation.add(originalData);
                            }
                        }
                        catch (Exception e) {

                        }
                        return originalData;
                    }
                }).build();

        adapter = new AccommodationAdapter(options);
        rView = findViewById(R.id.rView);
        rView.setLayoutManager(new GridLayoutManager(this, 1));
        rView.setAdapter(adapter);
*/
