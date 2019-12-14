package com.slws.ui.keyword;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class KeywordViewModel extends ViewModel {
    static ArrayList<String> mItemList = new ArrayList<>();

    public ArrayList<String> getItemList() {
        return mItemList;
    }
    public void setItemList(ArrayList<String> itemList) {
        mItemList = mItemList;
    }
    public void addToItemList(String s) {
        mItemList.add(s);
    }

    public void removeFromItemList(int i) {
        mItemList.remove(i);
    }

    public boolean itemListContains(String s) {
        return mItemList.contains(s);
    }
}
