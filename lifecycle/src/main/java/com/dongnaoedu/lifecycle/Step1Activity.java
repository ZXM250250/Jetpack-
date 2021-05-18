package com.dongnaoedu.lifecycle;

import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;

public class Step1Activity extends AppCompatActivity {

    private Chronometer chronometer;
    private long elapsedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
    }

    @Override
    protected void onResume() {
        super.onResume();
        chronometer.setBase(SystemClock.elapsedRealtime() - elapsedTime);
        chronometer.start();
    }


    @Override
    protected void onPause() {
        super.onPause();
        elapsedTime = SystemClock.elapsedRealtime() - chronometer.getBase();
        chronometer.stop();
    }

}