package com.dongnaoedu.paging.paging;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;

import com.dongnaoedu.paging.api.RetrofitClient;
import com.dongnaoedu.paging.db.MyDatabase;
import com.dongnaoedu.paging.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MovieBoundaryCallback extends PagedList.BoundaryCallback<Movie> {

    public static final int PER_PAGE = 8;
    private Application application;

    public MovieBoundaryCallback(Application application) {
        this.application = application;
    }

    @Override
    public void onZeroItemsLoaded() {
        super.onZeroItemsLoaded();
        //加载第一页数据
        getTopData();
    }

    private void getTopData() {
        int since = 0;
        RetrofitClient.getInstance()
                .getApi()
                .getMovies(since,PER_PAGE)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        if(response.body() != null){
                            //把数据传递给PagedList
                            insertMovies(response.body());
                            Log.d("ning","loadInitial:"+response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {

                    }
                });
    }

    //把网络数据，保存到数据库
    private void insertMovies(List<Movie> movies) {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                MyDatabase.getInstance(application)
                        .getMovieDao()
                        .insertMovies(movies);
            }
        });
    }

    @Override
    public void onItemAtEndLoaded(@NonNull Movie movie) {
        super.onItemAtEndLoaded(movie);
        //加载第二页数据
        getTopAfterData(movie);
    }

    private void getTopAfterData(Movie movie) {
        RetrofitClient.getInstance()
                .getApi()
                .getMovies(movie.id,PER_PAGE)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        if(response.body() != null){
                            insertMovies(response.body());
                            Log.d("ning","loadInitial:"+response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {

                    }
                });
    }
}
