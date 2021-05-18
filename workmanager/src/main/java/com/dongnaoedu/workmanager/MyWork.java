package com.dongnaoedu.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MyWork extends Worker {


    public MyWork(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String inputData = getInputData().getString("input_data");
        Log.d("ning","inputData:"+inputData);

        //SystemClock.sleep(2000);
        Log.d("ning","MyWork doWork");

        //任务执行完之后，返回数据
        Data outputData = new Data.Builder()
                .putString("output_data", "执行成功")
                .build();
        return Result.success(outputData);
    }
}
