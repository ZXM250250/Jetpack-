package com.dongnaoedu.databinding6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.dongnaoedu.databinding6.databinding.ItemBinding;

import java.util.List;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    List<Idol> idols;

    public RecyclerViewAdapter(List<Idol> idols) {
        this.idols = idols;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.item,
                parent,
                false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Idol idol = idols.get(position);
        holder.itemBinding.setIdol(idol);
    }

    @Override
    public int getItemCount() {
        return idols.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        private ItemBinding itemBinding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public MyViewHolder(ItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

}
