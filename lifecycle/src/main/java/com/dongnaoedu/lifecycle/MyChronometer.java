package com.dongnaoedu.lifecycle;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.Chronometer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MyChronometer extends Chronometer implements LifecycleObserver {

    private long elapsedTime;

    public MyChronometer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void startMeter(){
        setBase(SystemClock.elapsedRealtime() - elapsedTime);
        start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void stopMeter(){
        elapsedTime = SystemClock.elapsedRealtime() - getBase();
        stop();
    }
}
