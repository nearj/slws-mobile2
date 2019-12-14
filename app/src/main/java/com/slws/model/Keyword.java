package com.slws.model;

import androidx.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity
public class Keyword {
    @SerializedName("text")
    public String mText;

    public Keyword(String mText){
        this.mText = mText;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

}
