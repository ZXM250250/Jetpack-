package com.dongnaoedu.paging.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.dongnaoedu.paging.api.RetrofitClient;
import com.dongnaoedu.paging.model.Movie;
import com.dongnaoedu.paging.model.Movies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MovieDataSource extends PositionalDataSource<Movie> {

    public static final int PER_PAGE = 8;

    //页面首次加载数据会调用
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Movie> callback) {
        int startPosition = 0;
        RetrofitClient.getInstance()
                .getApi()
                .getMovies(startPosition,PER_PAGE)
                .enqueue(new Callback<Movies>() {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response) {
                        if(response.body() != null){
                            //把数据传递给PagedList
                            callback.onResult(response.body().movieList,
                                    response.body().start,
                                    response.body().total);
                            Log.d("ning","loadInitial:"+response.body().movieList);
                        }
                    }

                    @Override
                    public void onFailure(Call<Movies> call, Throwable t) {

                    }
                });
    }

    //加载下一页
    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Movie> callback) {
        RetrofitClient.getInstance()
                .getApi()
                .getMovies(params.startPosition,PER_PAGE)
                .enqueue(new Callback<Movies>() {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response) {
                        if(response.body() != null){
                            //把数据传递给PagedList
                            callback.onResult(response.body().movieList);
                            Log.d("ning","loadRange:"+response.body().movieList);
                        }
                    }

                    @Override
                    public void onFailure(Call<Movies> call, Throwable t) {

                    }
                });
    }
}
