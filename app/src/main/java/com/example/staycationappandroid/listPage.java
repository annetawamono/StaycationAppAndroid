package com.example.staycationappandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class listPage extends AppCompatActivity {

    //private AccommodationAdapter adapter;
    private RecyclerView rView;
    private TextView txtTitlePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_page);

        getSupportActionBar().setTitle("Staycation App");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        String checkInDate =  i.getStringExtra("checkInDate");
        String checkOutDate =  i.getStringExtra("checkOutDate");
        txtTitlePage = findViewById(R.id.txtTitlePage);

        //Showing the period selected before
        txtTitlePage.setText(checkInDate + " to " + checkOutDate);

        //getting the information from DB
        /*
        query = FirebaseDatabase.getInstance().getReference().child(category);
        FirebaseRecyclerOptions<Product> options = new FirebaseRecyclerOptions.Builder<Product>()
                .setQuery(query, Product.class)
                .build();

        adapter = new ProductAdapter(options);

        */
        rView = findViewById(R.id.rView);
        rView.setLayoutManager(new GridLayoutManager(this, 1));
        //rView.setAdapter(adapter);

    }
}