package com.dongnaoedu.livedata2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> progress;

    public MutableLiveData<Integer> getProgress() {
        if(progress == null){
            progress = new MutableLiveData<>();
            progress.setValue(0);
        }
        return progress;
    }
}
