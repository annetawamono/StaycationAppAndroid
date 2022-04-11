package com.example.staycationappandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.Holder> {

    //integer Array for images
    int[] images;

    //constructor for adapter class
    public SliderAdapter(int[] images){
        this.images = images;
    }

    //Implemented methods
    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        //inflating the layout
        View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.slider,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {

        //setting images according to the position
        viewHolder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getCount() {
        return images.length;
    }


    public class Holder extends SliderViewAdapter.ViewHolder{

        ImageView imageView;

        //constructor for holder class
        public Holder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }
}
