package com.dongnaoedu.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * @author ningchuanqi
 * @version V1.0
 */
@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "my_db.db";
    private static MyDatabase mInstance;

    //private MyDatabase(){}

    public static synchronized MyDatabase getInstance(Context context){
        if(mInstance == null){
            mInstance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class,
                    DATABASE_NAME)
                    //.allowMainThreadQueries()
                    .build();
        }
        return mInstance;
    }

    public abstract StudentDao getStudentDao();

}
