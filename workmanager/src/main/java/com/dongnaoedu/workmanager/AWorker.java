package com.dongnaoedu.workmanager;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class AWorker extends Worker {


    public AWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d("ning",this.getClass().getSimpleName()+" doWork");
        return Result.success();
    }
}
