package com.example.staycationappandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.staycationappandroid.Accommodation;
import com.example.staycationappandroid.Amenities;
import com.example.staycationappandroid.R;

import java.util.ArrayList;

public class AmenitiesAdapter extends RecyclerView.Adapter<AmenitiesAdapter.ViewHolder> {

    ArrayList<String> model;
    Context context;

    public AmenitiesAdapter(Context context,ArrayList<String> model){
        this.context = context;
        this.model=model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.singleamenity,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Glide.with(holder.imageView).load(model.get(position)).into(holder.imageView);
        holder.txtAmenity.setText(model.get(position));
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtAmenity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAmenity = itemView.findViewById(R.id.textAmenity);
        }
    }
}
