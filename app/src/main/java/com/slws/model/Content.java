package com.slws.model;

import com.google.gson.annotations.SerializedName;

public class Content {


    @SerializedName("title")
    private String mTitle;
    @SerializedName("detail")
    private String mDetails;
    @SerializedName("date")
    private String mDate;
    @SerializedName("departure")
    private String mDeparture;
    @SerializedName("numOfURL")
    private String mNumOfURL;


    public Content(String mTitle, String mDetails, String mDate, String mDeparture, String mNumOfURL) {
        this.mTitle = mTitle;
        this.mDetails = mDetails;
        this.mDate = mDate;
        this.mDeparture = mDeparture;
        this.mNumOfURL = mNumOfURL;
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

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmDeparture() {
        return mDeparture;
    }

    public void setmDeparture(String mDeparture) { this.mDeparture = mDeparture; }

    public String getmNumOfURL() {
        return mNumOfURL;
    }

    public void setmNumOfURL(String mNumOfURL) {
        this.mNumOfURL = mNumOfURL;
    }
}
