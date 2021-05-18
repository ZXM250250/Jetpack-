package com.dongnaoedu.lifecycle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Step2Activity extends AppCompatActivity {

    private MyChronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = findViewById(R.id.chronometer);
        getLifecycle().addObserver(chronometer);
    }


}