package com.dongnaoedu.livedata;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.textView);
        viewModel = new ViewModelProvider(this, new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        textView.setText(String.valueOf(viewModel.getCurrentSecond().getValue()));

        viewModel.getCurrentSecond().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer i) {
                textView.setText(String.valueOf(i));
            }
        });
        startTimer();
    }

    private void startTimer() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //非UI线程 postValue
                //UI线程 setValue
                viewModel.getCurrentSecond().postValue(viewModel.getCurrentSecond().getValue()+1);
            }
        },1000,1000);
    }
}