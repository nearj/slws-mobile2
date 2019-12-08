package com.slws.ui.dashboard;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.slws.model.Content;

public class ContentViewModel extends ViewModel {

    public ObservableField<Content> content = new ObservableField<>();


    public ContentViewModel(@NonNull Application application) {
        super();


    }
}
