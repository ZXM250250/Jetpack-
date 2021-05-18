package com.dongnaoedu.paging.paging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.dongnaoedu.paging.model.Movie;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MovieViewModel extends ViewModel {

    public LiveData<PagedList<Movie>> moviePagedList;

    public MovieViewModel(){
        PagedList.Config config = new PagedList.Config.Builder()
                //设置控件占位
                .setEnablePlaceholders(false)
                .setPageSize(MovieDataSource.PER_PAGE)
                //设置当距离底部还有多少条数据时开始加载下一页
                .setPrefetchDistance(2)
                //设置首次加载的数量
                .setInitialLoadSizeHint(MovieDataSource.PER_PAGE * 2)
                .setMaxSize(65536 * MovieDataSource.PER_PAGE)
                .build();
        moviePagedList = new LivePagedListBuilder<>(
                new MovieDataSourceFactory(),config)
                .build();
    }

}
