package com.dongnaoedu.paging.api;

import com.dongnaoedu.paging.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public interface Api {

    @GET("ikds.do")
    Call<List<Movie>> getMovies(
            @Query("since") int since,
            @Query("pagesize") int pagesize
    );

}
