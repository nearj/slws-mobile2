package com.slws.data;

import android.content.Context;

import com.google.gson.Gson;
import com.slws.data.local.ILocalData;
import com.slws.data.remote.IRemoteData;

public class AppDataManager implements DataManager {
    private static final String TAG = "AppDataManager";

    private static AppDataManager mDataManger;
    private final Context mContext;
    private final Gson mGson;
    private IRemoteData mRemoteData;
    private ILocalData mLocalData;

    private AppDataManager(Context context, IRemoteData remoteData, ILocalData localData, Gson gson) {
        mContext = context;
        mRemoteData = remoteData;
        mLocalData = localData;
        mGson = gson;
    }


}
