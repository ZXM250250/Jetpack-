package com.dongnaoedu.room2;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @author ningchuanqi
 * @version V1.0
 */
@Dao
public interface StudentDao {

    @Insert
    void insertStudent(Student... students);

    @Delete
    void deleteStudent(Student... students);

    @Query("DELETE FROM student")
    void deleteAllStudents();

    @Update
    void updateStudent(Student... students);

    @Query("SELECT * FROM student")
    LiveData<List<Student>> getAllStudentsLive();

    @Query("SELECT * FROM student WHERE id = :id")
    List<Student> getStudentById(int id);

}
