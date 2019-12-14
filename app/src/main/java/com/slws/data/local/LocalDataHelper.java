package com.slws.data.local;

import android.database.Observable;

import com.slws.model.Content;
import com.slws.model.Keyword;

import java.util.List;

public interface LocalDataHelper {
    Observable<List<Content>> getAllContent();

    List<Keyword> getAllKeyword();



}
