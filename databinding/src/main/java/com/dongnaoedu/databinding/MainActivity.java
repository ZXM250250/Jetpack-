package com.dongnaoedu.databinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.dongnaoedu.databinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        Idol idol = new Idol("斯嘉丽.约翰逊",4);
        activityMainBinding.setIdol(idol);

        activityMainBinding.setEventHandle(new EventHandleListener(this));
    }
}