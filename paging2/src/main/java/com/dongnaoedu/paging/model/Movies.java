package com.dongnaoedu.paging.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class Movies {

    @SerializedName("has_more")
    public boolean hasMore;

    @SerializedName("subjects")
    public List<Movie> movieList;


    @Override
    public String toString() {
        return "Movies{" +
                "hasMore=" + hasMore +
                ", movieList=" + movieList +
                '}';
    }
}
