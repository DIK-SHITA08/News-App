package com.example.newsapp.Models;

import android.content.Context;
import android.icu.text.UnicodeSetIterator;
import android.widget.Toast;

import com.example.newsapp.OnFetchDataListener;
import com.example.newsapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {

    //object for context
    Context contex;

    // object for api
    Retrofit retrofit= new Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

public void getNewsHeadline(OnFetchDataListener listener, String category,String query){

    //start api calling
    CallNewsApi callNewsApi=retrofit.create(CallNewsApi.class);
    // in for india we can use any country for getting their news

    Call<NewsApiResponse> call = callNewsApi.callHeadlines("in",category,query,contex.getString(R.string.api_key));

    //call api
    try{
        call.enqueue(new Callback<NewsApiResponse>() {
            @Override
            public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
            // if response is not succsseful then
                // just print toast message
                if(!response.isSuccessful())
            {
                Toast.makeText(contex,"Error !!",Toast.LENGTH_SHORT).show();
            }
             // get article ans message from listener
            listener.onFetchData(response.body().getArticles(),response.message());
            }

            @Override
            public void onFailure(Call<NewsApiResponse> call, Throwable t) {
              //just print fail message
                listener.onError("Request Fail");
            }
        });
    }
    catch(Exception e){
  e.printStackTrace();
    }
}
    //constructor for requestManager
    //we will manage api calls here
    public RequestManager(Context contex) {
        this.contex = contex;
    }

    //interface for calling news Api
    public interface CallNewsApi{
        @GET("top-headlines")
        //All these are Request parameters
        //we just add 3 we can add page ,sources,pageSize
        Call<NewsApiResponse> callHeadlines(
                //The 2-letter ISO 3166-1 code of the country you
                // want to get headlines for
                @Query("country") String country,
                //The category you want to get headlines
                @Query("category") String category,
                //Keywords or a phrase to search for.
                @Query("q") String query,
                //Your API key.
                @Query("apiKey") String apiKey
        );



    }
}
