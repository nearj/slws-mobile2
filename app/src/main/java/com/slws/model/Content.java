package com.slws.model;

import com.google.gson.annotations.SerializedName;

public class Content {
    @SerializedName("title")
    public String mTitle;
    @SerializedName("detail")
    public String mDetail;
    @SerializedName("time")
    public String mDate;
    @SerializedName("departure")
    public String mDeparture;
    @SerializedName("author")
    public String mAuthor;
    public boolean mInterest;

    /**
     * @param title     title
     * @param author
     * @param departure
     * @param date
     * @param detail
     */
    public Content(String title, String author, String departure, String date, String detail) {
        this.mTitle = title;
        this.mAuthor = author;
        this.mDeparture = departure;
        this.mDate = date;
        this.mDetail = detail;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getDetail() {
        return mDetail;
    }

    public void setDetail(String detail) {
        this.mDetail = detail;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public String getDeparture() {
        return mDeparture;
    }

    public void setDeparture(String departure) {
        this.mDeparture = departure;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
    }

    public boolean getInterest() {
        return this.mInterest;
    }

    public void setInterest(boolean mInterest) {
        this.mInterest = mInterest;
    }
}
