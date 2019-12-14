package com.slws.ui.favorite;

import androidx.lifecycle.ViewModel;

import com.slws.utils.BoardTitle;

import java.util.ArrayList;
import java.util.List;

public class FavoriteViewModel extends ViewModel {
    public static List<Boolean> mFavoriteList = new ArrayList<Boolean>() {
        {
            for (int i = 0; i < BoardTitle.size; i++) {
                add(false);
            }
        }
    };
}
