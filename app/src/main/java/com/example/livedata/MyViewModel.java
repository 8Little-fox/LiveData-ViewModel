package com.example.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<User> data;

    public MyViewModel() {
        data = new MutableLiveData<User>();
    }

    public MutableLiveData<User> getData() {
        return data;
    }

    //增加数据变动
    public void setUser(User user) {
        data.setValue(user);
    }
}
