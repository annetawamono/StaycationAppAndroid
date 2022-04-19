package com.example.staycationappandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {

    ArrayList<String> images = new ArrayList<>();

    public SliderAdapter(ArrayList<String> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Loading images url from firebase and displaying with glide
        Glide.with(holder.itemView.getContext()).load(FirebaseStorage.getInstance().getReferenceFromUrl(images.get(position))).into(holder.sliderView);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

            ImageView sliderView;

            public  ViewHolder(@NonNull View itemView){
                super(itemView);

                sliderView = itemView.findViewById(R.id.imageSlider);
            }
        }
}
