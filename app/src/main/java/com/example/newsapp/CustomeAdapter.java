package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.io.ObjectInputStream;
import java.util.List;

public class CustomeAdapter extends RecyclerView.Adapter<CustomeViewHolder> {

    // create object that we pass for custome Adapter
    //create object for context
     private Context context;
     private List<NewsHeadlines> headlines;
 //create object for listner
    private SelectListener listener;


    //constructor for contex and headlines
    public CustomeAdapter(Context context, List<NewsHeadlines> headlines,SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener=listener;


    }
   // Implements methodas and constructor
    @NonNull
    @Override
    public CustomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomeViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomeViewHolder holder, int position) {
        // add objects of news headline
        //to show the text of article into text view
        holder.text_title.setText(headlines.get(position).getTitle());
        // for getting source from api
        holder.text_source.setText(headlines.get(position).getSource().getName());

        // check is our image is null or not
        //if not then load the url
        if(headlines.get(position).getUrlToImage()!=null)
        {
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }

        //create onclick listnere for CardView
        //who is main container of recycler view
       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listener.OnNewsClicked(headlines.get(position));
           }
       });
    }

    @Override
    public int getItemCount() {

        return headlines.size();
    }
}
