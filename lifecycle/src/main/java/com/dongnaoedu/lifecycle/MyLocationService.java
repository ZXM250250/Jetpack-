package com.dongnaoedu.lifecycle;

import android.util.Log;

import androidx.lifecycle.LifecycleService;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MyLocationService extends LifecycleService {

    public MyLocationService() {
        Log.d("ning","MyLocationService");
        MyLocationObserver observer = new MyLocationObserver(this);
        getLifecycle().addObserver(observer);
    }
}
