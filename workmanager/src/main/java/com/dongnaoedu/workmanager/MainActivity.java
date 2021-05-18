package com.dongnaoedu.workmanager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mAddWork(View view) {
        //设置触发条件
        Constraints constraints = new Constraints.Builder()
                // .setRequiredNetworkType(NetworkType.CONNECTED)//网络连接时执行
                // .setRequiresBatteryNotLow(true) //不在电量不足执行
                // .setRequiresCharging(true) //在充电时执行
                // .setRequiresStorageNotLow(true) //不在存储容量不足时执行
                // .setRequiresDeviceIdle(true) //在待机状态下执行 调用需要API级别最低为23
                // NetworkType.NOT_REQUIRED：对网络没有要求
                // NetworkType.CONNECTED：网络连接的时候执行
                // NetworkType.UNMETERED：不计费的网络比如WIFI下执行
                // NetworkType.NOT_ROAMING：非漫游网络状态
                // NetworkType.METERED：计费网络比如3G，4G下执行。
                //注意：不代表恢复网络了，就立马执行
                .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
                .build();

        Data inputData = new Data.Builder()
                .putString("input_data","jack")
                .build();

        //配置任务
        //一次性执行的任务
        OneTimeWorkRequest workRequest1 = new OneTimeWorkRequest.Builder(MyWork.class)
                //设置触发条件
                .setConstraints(constraints)
                //设置延迟执行
                .setInitialDelay(5, TimeUnit.SECONDS)
                //指数退避策略
                .setBackoffCriteria(BackoffPolicy.LINEAR, Duration.ofSeconds(2))
                //设置tag标签
                .addTag("workRequest1")
                //参数传递
                .setInputData(inputData)
                .build();

        //周期性任务
        //不能少于15分钟
        PeriodicWorkRequest workRequest2 = new PeriodicWorkRequest.Builder(MyWork.class,Duration.ofMinutes(15))
                .build();

        //任务提交给WorkManager
        WorkManager workManager = WorkManager.getInstance(this);
        workManager.enqueue(workRequest1);

        //观察任务状态
        workManager.getWorkInfoByIdLiveData(workRequest1.getId()).observe(this, new Observer<WorkInfo>() {
            @Override
            public void onChanged(WorkInfo workInfo) {
                Log.d("ning",workInfo.toString());
                if(workInfo != null && workInfo.getState() == WorkInfo.State.SUCCEEDED){
                    String outputData = workInfo.getOutputData().getString("output_data");
                    Log.d("ning","outputData:"+outputData);
                }
            }
        });

        //取消任务
        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                workManager.cancelWorkById(workRequest1.getId());
            }
        }, 2000);*/

    }
}