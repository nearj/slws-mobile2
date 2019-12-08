package com.slws.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import android.os.Bundle;
import com.slws.R;
import com.slws.ui.home.HtmlParser;


public class HomeViewModel extends ViewModel implements ParserResponseInterface{

    private MutableLiveData<String> mText;


    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public LiveData<String> getText() {
        return mText;
    }
}