package com.dongnaoedu.databinding4;

import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * @author ningchuanqi
 * @version V1.0
 */
public class UserViewModel extends BaseObservable {

    private User user;

    public UserViewModel(){
        this.user = new User("Jack");
    }

    @Bindable
    public String getUserName(){
        return user.userName;
    }

    public void setUserName(String userName){
        if(userName != null && !userName.equals(user.userName)){
            user.userName = userName;
            Log.d("ning","set username:"+userName);
            notifyPropertyChanged(BR.userName);
        }
    }
}
