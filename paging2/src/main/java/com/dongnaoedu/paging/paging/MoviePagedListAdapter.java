package com.dongnaoedu.paging.paging;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dongnaoedu.paging.R;
import com.dongnaoedu.paging.model.Movie;
import com.squareup.picasso.Picasso;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MoviePagedListAdapter extends PagedListAdapter<Movie, MoviePagedListAdapter.MovieViewHolder> {

    private Context context;

    //差分，只更新需要更新的元素，而不是整个刷新数据源
    private static final DiffUtil.ItemCallback<Movie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
            return oldItem.equals(newItem);
        }
    };

    public MoviePagedListAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MovieViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = getItem(position);
        if(movie != null){
            Picasso.get()
                    .load(movie.cover)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(holder.imageView);
            if(movie.title.length() >= 8){
                movie.title = movie.title.substring(0,7);
            }
            holder.textViewTitle.setText(movie.title);
            holder.textViewRate.setText(movie.rate);
        }
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textViewTitle;
        private TextView textViewRate;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textViewTitle = itemView.findViewById(R.id.textViewTitle);
            this.textViewRate = itemView.findViewById(R.id.textViewRate);
        }
    }
}
