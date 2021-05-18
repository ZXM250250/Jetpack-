package com.dongnaoedu.room2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class StudentRepository {

    private StudentDao studentDao;

    public StudentRepository(Context context) {
        MyDatabase database = MyDatabase.getInstance(context);
        this.studentDao = database.getStudentDao();
    }

    public void insertStudent(Student... students){
        new InsertStudentTask(studentDao).execute(students);
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

    public void deleteStudent(Student... students){
        new DeleteStudentTask(studentDao).execute(students);
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

    public void deleteAllStudents(){
        new DeleteAllStudentsTask(studentDao).execute();
    }

    class DeleteAllStudentsTask extends AsyncTask<Void, Void, Void> {

        private StudentDao studentDao;

        public DeleteAllStudentsTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... Void) {
            studentDao.deleteAllStudents();
            return null;
        }
    }


    public void updateStudent(Student... students){
        new UpdateStudentTask(studentDao).execute(students);
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


    public LiveData<List<Student>> getAllStudentsLive(){
        return studentDao.getAllStudentsLive();
    }

}
