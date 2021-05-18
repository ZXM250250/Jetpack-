package com.dongnaoedu.room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StudentRecyclerViewAdapter adapter;
    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycleView = findViewById(R.id.recycleView);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        List<Student> students = new ArrayList<>();
        adapter = new StudentRecyclerViewAdapter(students);
        recycleView.setAdapter(adapter);

        MyDatabase database = MyDatabase.getInstance(this);
        studentDao = database.getStudentDao();
    }

    public void mInsert(View view) {
        Student s1 = new Student("Jack", 20);
        Student s2 = new Student("Rose", 18);
        new InsertStudentTask(studentDao).execute(s1,s2);
    }

    class InsertStudentTask extends AsyncTask<Student, Void, Void> {

        private StudentDao studentDao;

        public InsertStudentTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.insertStudent(students);
            return null;
        }
    }

    public void mDelete(View view) {
        Student s1 = new Student(2);
        new DeleteStudentTask(studentDao).execute(s1);
    }

    class DeleteStudentTask extends AsyncTask<Student, Void, Void> {

        private StudentDao studentDao;

        public DeleteStudentTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.deleteStudent(students);
            return null;
        }
    }

    public void mUpdate(View view) {
        Student s1 = new Student(3,"Jason", 21);
        new UpdateStudentTask(studentDao).execute(s1);
    }

    class UpdateStudentTask extends AsyncTask<Student, Void, Void> {

        private StudentDao studentDao;

        public UpdateStudentTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.updateStudent(students);
            return null;
        }
    }

    public void mQuery(View view) {
        new GetAllStudentTask(studentDao).execute();
    }

    class GetAllStudentTask extends AsyncTask<Void,Void,Void>{

        private StudentDao studentDao;

        public GetAllStudentTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<Student> students = studentDao.getAllStudent();
            adapter.setStudents(students);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter.notifyDataSetChanged();
        }
    }
}