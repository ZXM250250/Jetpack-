package com.dongnaoedu.databinding5;

import android.util.Log;

import androidx.databinding.ObservableField;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class UserViewModel {

    private ObservableField<User> userObservableField;

    public UserViewModel(){
        User user = new User("Jack");
        userObservableField = new ObservableField<>();
        userObservableField.set(user);
    }


    public String getUserName(){
        return userObservableField.get().userName;
    }

    public void setUserName(String userName){
        Log.d("ning","userObservableField:"+userName);
        userObservableField.get().userName = userName;
    }

}
