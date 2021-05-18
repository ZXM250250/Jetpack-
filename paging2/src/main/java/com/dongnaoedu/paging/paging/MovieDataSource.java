package com.dongnaoedu.paging.paging;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

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
public class MovieDataSource extends PageKeyedDataSource<Integer,Movie> {

    public static final int PER_PAGE = 8;
    public static final int FIRST_PAGE = 1;


    //第一页
    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Movie> callback) {
        RetrofitClient.getInstance()
                .getApi()
                .getMovies(FIRST_PAGE,PER_PAGE)
                .enqueue(new Callback<Movies>() {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response) {
                        if(response.body() != null){
                            //把数据传递给PagedList
                            callback.onResult(response.body().movieList,null,FIRST_PAGE+1);
                            Log.d("ning","loadInitial:"+response.body().movieList);
                        }
                    }

                    @Override
                    public void onFailure(Call<Movies> call, Throwable t) {

                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {

    }

    //下一页
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {
        RetrofitClient.getInstance()
                .getApi()
                .getMovies(params.key,PER_PAGE)
                .enqueue(new Callback<Movies>() {
                    @Override
                    public void onResponse(Call<Movies> call, Response<Movies> response) {
                        if(response.body() != null){
                            //把数据传递给PagedList
                            Integer nextKey = response.body().hasMore ? params.key + 1 : null;
                            callback.onResult(response.body().movieList,nextKey);
                            Log.d("ning","loadInitial:"+response.body().movieList);
                        }
                    }

                    @Override
                    public void onFailure(Call<Movies> call, Throwable t) {

                    }
                });
    }
}
