package com.slws.utils;

public class Text {
    private String mDetails;
    private String mAuthor;
    private String mNumOfURL;

    public Text(String mNumOfURL, String mDetails, String mAuthor) {
        this.mDetails = mDetails;
        this.mAuthor = mAuthor;
        this.mNumOfURL = mNumOfURL;
    }

    public String getDetails() {
        return mDetails;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getURLAdd() {
        return mNumOfURL;
    }
}

