package com.example.newsapp.Models;

import java.io.Serializable;

//source object where we have two items
// id and name in json file
public class Source implements Serializable {
    //
    String id="";
    String name="";

    //getter and setter method for id and name
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
