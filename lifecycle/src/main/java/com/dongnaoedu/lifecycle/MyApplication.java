package com.dongnaoedu.lifecycle;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle()
                .addObserver(new ApplicationObserver());
    }
}
