package com.dongnaoedu.paging.api;

import com.dongnaoedu.paging.model.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public interface Api {

    @GET("pds.do")
    Call<Movies> getMovies(
            @Query("start") int since,
            @Query("count") int perPage
    );

}
