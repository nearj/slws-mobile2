package com.example.slws.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CardViewModel extends ViewModel {
    private MutableLiveData<String> mTitle = new MutableLiveData<>();
    private MutableLiveData<String> mContent = new MutableLiveData<>();

    public LiveData<String> getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle.setValue(title);
    }

    public LiveData<String> getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent.setValue(content);
    }
}
