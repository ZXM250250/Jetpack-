package com.dongnaoedu.paging.paging;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.dongnaoedu.paging.model.Movie;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MovieDataSourceFactory extends DataSource.Factory<Integer, Movie> {
    @NonNull
    @Override
    public DataSource<Integer, Movie> create() {
        return new MovieDataSource();
    }
}
