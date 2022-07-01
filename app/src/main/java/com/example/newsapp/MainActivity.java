package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.newsapp.Models.NewsApiResponse;
import com.example.newsapp.Models.NewsHeadlines;
import com.example.newsapp.Models.RequestManager;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener, View.OnClickListener{

    //object for recyclerview
    RecyclerView recyclerView;

    //object for Custom adapter
    CustomeAdapter adapter;

    ProgressDialog dialog;

    //Object for button
    Button b1,b2,b3,b4,b5,b6,b7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for dailog box
        dialog=new ProgressDialog(this);
        dialog.setTitle("Fetching news atticles");
        dialog.show();

        //Intilaiaze buttons
        b1=findViewById(R.id.btn_1);
        b1.setOnClickListener(this);

        b2=findViewById(R.id.btn_2);
        b2.setOnClickListener(this);

        b3=findViewById(R.id.btn_3);
        b3.setOnClickListener(this);

        b4=findViewById(R.id.btn_4);
        b4.setOnClickListener(this);

        b5=findViewById(R.id.btn_5);
        b5.setOnClickListener(this);

        b6=findViewById(R.id.btn_6);
        b6.setOnClickListener(this);

        b7=findViewById(R.id.btn_7);
        b7.setOnClickListener(this);




        RequestManager manager = new RequestManager(this);

        //call manager object
        manager.getNewsHeadline(listener,"general",null);
    }
    private final OnFetchDataListener<NewsApiResponse> listener=new OnFetchDataListener<NewsApiResponse>() {


        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {

            showNews(list);
        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {

       //intilaize recycler view
        recyclerView = findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
   //intilaize customerAdopter
        adapter=new CustomeAdapter(this,list,this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void OnNewsClicked(NewsHeadlines headlines){
//calling new Activity
        startActivity(new Intent(MainActivity.this,DetailsActivity.class).putExtra("data",headlines));
    }

    @Override
    public void onClick(View view) {
        Button button=(Button) view;
        String category=button.getText().toString();

        // create progress dailoge
        dialog.setTitle("Fetching news articles of"+category);
        dialog.show();
        RequestManager manager = new RequestManager(this);

        //call manager object
        manager.getNewsHeadline(listener,category,null);
    }
}