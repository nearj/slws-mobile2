package com.example.slws.Data;

public class Content {

    private String mSender;
    private String mTitle;
    private String mDetails;
    private String mTime;

    public Content(String mSender, String mTitle, String mDetails, String mTime) {
        this.mTitle = mTitle;
        this.mDetails = mDetails;
        this.mTime = mTime;
    }

    public String getmTitle() {
        return mTitle;
    }


    public String getmDetails() {
        return mDetails;
    }


    public String getmTime() {
        return mTime;
    }
}
