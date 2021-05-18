package com.dongnaoedu.room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class StudentRecyclerViewAdapter extends RecyclerView.Adapter {

    List<Student> students;

    public StudentRecyclerViewAdapter(List<Student> students) {
        this.students = students;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
       return new MyViewHoder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Student student = students.get(position);
        TextView tvId = holder.itemView.findViewById(R.id.tvId);
        tvId.setText(String.valueOf(student.id));

        TextView tvName = holder.itemView.findViewById(R.id.tvName);
        tvName.setText(student.name);

        TextView tvAge = holder.itemView.findViewById(R.id.tvAge);
        tvAge.setText(String.valueOf(student.age));
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    static class MyViewHoder extends RecyclerView.ViewHolder {

        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
