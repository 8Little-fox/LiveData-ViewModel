package com.example.app1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

public class BlankViewModel extends ViewModel {
    public MutableLiveData<User1>data;
    public MutableLiveData<User1> getData() {
        if (data==null){
            data=new MutableLiveData<User1>();
        }
        return data;
    }
    public void setUser(User1 user1){
        data.setValue(user1);
    }
}
