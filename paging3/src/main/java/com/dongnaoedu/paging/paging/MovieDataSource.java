package com.dongnaoedu.paging.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.ItemKeyedDataSource;

import com.dongnaoedu.paging.api.RetrofitClient;
import com.dongnaoedu.paging.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MovieDataSource extends ItemKeyedDataSource<Integer,Movie> {

    public static final int PER_PAGE = 8;


    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Movie> callback) {
        int since = 0;
        RetrofitClient.getInstance()
                .getApi()
                .getMovies(since,PER_PAGE)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        if(response.body() != null){
                            //把数据传递给PagedList
                            callback.onResult(response.body());
                            Log.d("ning","loadInitial:"+response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Movie> callback) {
        RetrofitClient.getInstance()
                .getApi()
                .getMovies(params.key,PER_PAGE)
                .enqueue(new Callback<List<Movie>>() {
                    @Override
                    public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                        if(response.body() != null){
                            //把数据传递给PagedList
                            callback.onResult(response.body());
                            Log.d("ning","loadInitial:"+response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Movie>> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Movie> callback) {

    }

    @NonNull
    @Override
    public Integer getKey(@NonNull Movie movie) {
        return movie.id;
    }
}
