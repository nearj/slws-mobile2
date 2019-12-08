package com.slws.ui.dashboard;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.slws.model.Content;

public class ContentViewModel extends ViewModel {
    private final LiveData<Content> contentLiveData = new MutableLiveData<>();
    public ObservableField<Content> content = new ObservableField<>();


    public ContentViewModel(@NonNull Application application) {
        super();

    }
}
