package com.kewenc.viewmodelfragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    public MutableLiveData<String> titleText = new MutableLiveData<String>();

    public void setTitleText(String text) {
        titleText.setValue(text);
    }

}
