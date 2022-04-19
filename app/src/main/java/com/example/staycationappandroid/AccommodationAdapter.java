package com.example.staycationappandroid;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class AccommodationAdapter extends FirebaseRecyclerAdapter<Accommodation, AccommodationAdapter.MyViewHolder> {

    public AccommodationAdapter(FirebaseRecyclerOptions<Accommodation> options) {super(options);}

    @Override
    public AccommodationAdapter.MyViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new AccommodationAdapter.MyViewHolder(layoutInflater, parent);
    }

    @Override
    protected void onBindViewHolder(@NonNull AccommodationAdapter.MyViewHolder holder, int position, @NonNull Accommodation model) {
        Utilities lUtilities = new Utilities();

        String vInfo = model.getDescription();
        ArrayList <String> vArrayImages = model.getImage();

        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(vArrayImages.get(1));
        Glide.with(holder.itemView.getContext()).load(storageReference).into(holder.imgAccommodation);

        holder.txtTitle.setText(model.getTitle());
        holder.txtRate.setText(lUtilities.formatNumber(model.getRating()));
        holder.txtPrice.setText("C$ "+lUtilities.formatNumber(model.getPrice()));

        //Loading the images array and removing Null values
        ArrayList <String> dArrayImages = new ArrayList<String>();
        for (String item : model.getImage()) {
            if(item != null && !TextUtils.isEmpty(item)){
                System.out.println(item);
                dArrayImages.add(item);
            }
        }

        //Loading the amenities array and removing null values
        ArrayList <String> Amenities = new ArrayList<String>();
        for (String item : model.getAmenities()) {
            if(item != null && !TextUtils.isEmpty(item)){
                //System.out.println(item);
                Amenities.add(item);
            }
        }

        holder.btnDetail.setOnClickListener( view -> {
            Intent intentDetail = new Intent(view.getContext(), activity_details.class);
            intentDetail.putExtra("title", model.getTitle());
            intentDetail.putExtra("info", vInfo);
            intentDetail.putExtra("rate", lUtilities.formatNumber(model.getRating()));
            intentDetail.putExtra("price", lUtilities.formatNumber(model.getPrice()));
            intentDetail.putExtra("ownerName", model.getOwner());
            intentDetail.putExtra("Address", model.getCity());
            intentDetail.putExtra("amenities", Amenities);
            intentDetail.putExtra("longitude", Double.valueOf(model.getLongitude()).toString());
            intentDetail.putExtra("latitude", Double.valueOf(model.getLat()).toString());
            intentDetail.putExtra("city",model.getCity());
            intentDetail.putExtra("imageURL",dArrayImages);
            view.getContext().startActivity(intentDetail);
        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAccommodation;
        TextView txtTitle;
        TextView txtRate;
        TextView txtPrice;
        Button btnDetail;

        public MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_page_layout, parent, false));

            imgAccommodation = itemView.findViewById(R.id.imgAccommodation);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtRate = itemView.findViewById(R.id.txtRate);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            btnDetail = itemView.findViewById(R.id.btnDetail);

        }
    }
}