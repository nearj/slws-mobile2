package com.slws.model;
import android.widget.Button;

import com.google.gson.annotations.SerializedName;

public class listContent {
    @SerializedName("text")
    public String mText;
    //@SerializedName("deleteButton");
    public Button mDeleteButton;
    public listContent(String mText, Button mDeleteButton){
        this.mText = mText;
        this.mDeleteButton = mDeleteButton;
    }
    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

}
