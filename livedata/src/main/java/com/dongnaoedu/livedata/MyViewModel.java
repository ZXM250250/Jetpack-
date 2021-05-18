package com.dongnaoedu.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class MyViewModel extends ViewModel {
    private MutableLiveData<Integer> currentSecond;

    public MutableLiveData<Integer> getCurrentSecond() {
        if(currentSecond == null){
            currentSecond = new MutableLiveData<>();
            currentSecond.setValue(0);
        }
        return currentSecond;
    }
}
