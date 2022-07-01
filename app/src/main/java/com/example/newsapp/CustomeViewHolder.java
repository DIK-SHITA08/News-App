package com.example.newsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

// for News Headline
public class CustomeViewHolder extends RecyclerView.ViewHolder {
 //objects for view items
    //for recyclervie
    //TextView for title and Source
    TextView text_title,text_source;

    //ImageView For photo
    ImageView img_headline;

    // card view which is used for
    //on click listener for RecycleView
    CardView cardView;

    // constructor for ViewHolder
    public CustomeViewHolder(@NonNull View itemView) {
        super(itemView);

        // intilaize objects
        text_title = itemView.findViewById(R.id.text_title);
        text_source = itemView.findViewById(R.id.text_source);
        img_headline = itemView.findViewById(R.id.img_headline);
        cardView = itemView.findViewById(R.id.main_container);
    }


}
