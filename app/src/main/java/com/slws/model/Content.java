package com.slws.model;

import com.google.gson.annotations.SerializedName;

public class Content {


    @SerializedName("title")
    private String mTitle;
    @SerializedName("detail")
    private String mDetails;
    @SerializedName("time")
    private String mTime;

    public Content(String mTitle, String mDetails, String mTime) {
        this.mTitle = mTitle;
        this.mDetails = mDetails;
        this.mTime = mTime;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDetails() {
        return mDetails;
    }

    public void setmDetails(String mDetails) {
        this.mDetails = mDetails;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }
}
