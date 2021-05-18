package com.dongnaoedu.paging.paging;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.dongnaoedu.paging.db.MovieDao;
import com.dongnaoedu.paging.db.MyDatabase;
import com.dongnaoedu.paging.model.Movie;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MovieViewModel extends AndroidViewModel {

    public static final int PER_PAGE = 8;
    public LiveData<PagedList<Movie>> moviePagedList;


    public MovieViewModel(@NonNull Application application) {
        super(application);
        MovieDao movieDao = MyDatabase.getInstance(application).getMovieDao();
        moviePagedList = new LivePagedListBuilder<>(
                movieDao.getMovieList(),
                PER_PAGE)
                .setBoundaryCallback(new MovieBoundaryCallback(application))
                .build();
    }

    /**
     * 刷新
     */
    public void refresh(){
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                MyDatabase.getInstance(getApplication())
                        .getMovieDao()
                        .clear();
            }
        });
    }
}
