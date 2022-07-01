package com.example.newsapp.Models;

import java.io.Serializable;
import java.util.List;

//for al the response
public class NewsApiResponse implements Serializable {
    String status;
    int totalResults;
    // article array which consist of all the object
    //inside NewsHeaderlines
    List<NewsHeadlines> articles;

    // all getter and setter methods for
    // all the object and the article list
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsHeadlines> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsHeadlines> articles) {
        this.articles = articles;
    }
}
