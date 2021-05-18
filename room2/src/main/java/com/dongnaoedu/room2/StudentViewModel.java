package com.dongnaoedu.room2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class StudentViewModel extends AndroidViewModel {

    private StudentRepository repository;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        this.repository = new StudentRepository(application);
    }

    public void insertStudent(Student... students){
        repository.insertStudent(students);
    }

    public void deleteStudent(Student... students){
        repository.deleteStudent(students);
    }

    public void deleteAllStudents(){
        repository.deleteAllStudents();
    }

    public void updateStudent(Student... students){
        repository.updateStudent(students);
    }

    public LiveData<List<Student>> getAllStudentsLive(){
        return repository.getAllStudentsLive();
    }

}
