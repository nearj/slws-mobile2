package com.slws.model;
import android.widget.Button;

import com.google.gson.annotations.SerializedName;

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
