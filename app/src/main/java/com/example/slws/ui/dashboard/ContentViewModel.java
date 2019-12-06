package com.example.slws.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class ContentViewModel extends ViewModel {
    private MutableLiveData<String> mTitle = new MutableLiveData<>();
    private MutableLiveData<String> mDetail = new MutableLiveData<>();
    private LiveData<String> _mTitle = Transformations.map(mTitle, (input) -> {
        return input;
    });
    private LiveData<String> _mDetail = Transformations.map(mDetail, (input) -> {
        return input;
    });

    public LiveData<String> getTitle() {
        return _mTitle;
    }

    public void setTitle(String title) {
        mTitle.setValue(title);
    }

    public LiveData<String> getDetail() {
        return _mDetail;
    }

    public void setDetail(String detail) {
        mDetail.setValue(detail);
    }
}
