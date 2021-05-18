package com.dongnaoedu.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MyViewModel extends AndroidViewModel {

    public int number;

    public MyViewModel(@NonNull Application application) {
        super(application);
    }


}
