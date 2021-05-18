package com.dongnaoedu.paging.db;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.dongnaoedu.paging.model.Movie;

import java.util.List;

/**
 * @author ningchuanqi
 * @version V1.0
 */
@Dao
public interface MovieDao {

    @Insert
    void insertMovies(List<Movie> movies);

    @Query("DELETE FROM movie")
    void clear();

    @Query("SELECT * FROM movie")
    DataSource.Factory<Integer,Movie> getMovieList();
}
