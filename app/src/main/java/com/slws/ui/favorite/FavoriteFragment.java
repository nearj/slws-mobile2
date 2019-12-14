package com.slws.ui.favorite;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.slws.R;

import java.util.List;
import java.util.Map;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FavoriteFragment extends Fragment {
    List<Map.Entry<CheckBox, Boolean>> checkBoxList;
    private boolean cur;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favorite, container, false);

        CheckBox cb1 = root.findViewById(R.id.checkBox);
        CheckBox cb2 = root.findViewById(R.id.checkBox2);
        CheckBox cb3 = root.findViewById(R.id.checkBox3);
        CheckBox cb4 = root.findViewById(R.id.checkBox4);
        CheckBox cb5 = root.findViewById(R.id.checkBox5);
        CheckBox cb6 = root.findViewById(R.id.checkBox6);
        CheckBox cb7 = root.findViewById(R.id.checkBox7);
        CheckBox cb8 = root.findViewById(R.id.checkBox8);
        Log.d(TAG, "onCreateView: " + FavoriteViewModel.mFavoriteList.toString());

        cb1.setChecked(FavoriteViewModel.mFavoriteList.get(0));
        cb2.setChecked(FavoriteViewModel.mFavoriteList.get(1));
        cb3.setChecked(FavoriteViewModel.mFavoriteList.get(2));
        cb4.setChecked(FavoriteViewModel.mFavoriteList.get(3));
        cb5.setChecked(FavoriteViewModel.mFavoriteList.get(4));
        cb6.setChecked(FavoriteViewModel.mFavoriteList.get(5));
        cb7.setChecked(FavoriteViewModel.mFavoriteList.get(6));
        cb8.setChecked(FavoriteViewModel.mFavoriteList.get(7));


        cb1.setOnClickListener((View v) -> {
            cur = FavoriteViewModel.mFavoriteList.get(0);
            cb1.setChecked(!cur);
            FavoriteViewModel.mFavoriteList.set(0, !cur);
        });
        cb2.setOnClickListener((View v) -> {
            cur = FavoriteViewModel.mFavoriteList.get(1);
            cb2.setChecked(!cur);
            FavoriteViewModel.mFavoriteList.set(1, !cur);
        });
        cb3.setOnClickListener((View v) -> {
            cur = FavoriteViewModel.mFavoriteList.get(2);
            cb3.setChecked(!cur);
            FavoriteViewModel.mFavoriteList.set(2, !cur);
        });
        cb4.setOnClickListener((View v) -> {
            cur = FavoriteViewModel.mFavoriteList.get(3);
            cb4.setChecked(!cur);
            FavoriteViewModel.mFavoriteList.set(3, !cur);
        });
        cb5.setOnClickListener((View v) -> {
            cur = FavoriteViewModel.mFavoriteList.get(4);
            cb5.setChecked(!cur);
            FavoriteViewModel.mFavoriteList.set(4, !cur);
        });
        cb6.setOnClickListener((View v) -> {
            cur = FavoriteViewModel.mFavoriteList.get(5);
            cb6.setChecked(!cur);
            FavoriteViewModel.mFavoriteList.set(5, !cur);
        });
        cb7.setOnClickListener((View v) -> {
            cur = FavoriteViewModel.mFavoriteList.get(6);
            cb7.setChecked(!cur);
            FavoriteViewModel.mFavoriteList.set(6, !cur);
        });
        cb8.setOnClickListener((View v) -> {
            cur = FavoriteViewModel.mFavoriteList.get(7);
            cb8.setChecked(!cur);
            FavoriteViewModel.mFavoriteList.set(7, !cur);
        });

        return root;
    }

}
