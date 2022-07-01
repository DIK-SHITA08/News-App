package com.example.newsapp;

import com.example.newsapp.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse>{
    //for fetching data from api+
    void onFetchData(List<NewsHeadlines> list,String message);

    //for handling errors
    void onError(String message);

}
