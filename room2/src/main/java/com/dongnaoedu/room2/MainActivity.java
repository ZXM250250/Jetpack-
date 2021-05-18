package com.dongnaoedu.room2;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentRecyclerViewAdapter adapter;
    private StudentViewModel studentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycleView = findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        List<Student> students = new ArrayList<>();
        adapter = new StudentRecyclerViewAdapter(students);
        recycleView.setAdapter(adapter);

        studentViewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(StudentViewModel.class);
        studentViewModel.getAllStudentsLive().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                adapter.setStudents(students);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void mInsert(View view) {
        Student s1 = new Student("Jack", 20);
        Student s2 = new Student("Rose", 18);
        studentViewModel.insertStudent(s1,s2);
    }



    public void mDelete(View view) {
        Student s1 = new Student(2);
        studentViewModel.deleteStudent(s1);
    }



    public void mUpdate(View view) {
        Student s1 = new Student(3,"Jason", 21);
        studentViewModel.updateStudent(s1);
    }


    public void mClear(View view) {
        studentViewModel.deleteAllStudents();
    }
}