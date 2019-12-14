package com.slws.ui.interests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.slws.R;
import com.slws.data.AppDataManager;
import com.slws.databinding.FragmentInterestsBinding;
import com.slws.model.Content;
import com.slws.utils.BoardTitle;

public class InterestsFragment extends Fragment {
    Content c;
    TextView textView;
    private InterestsViewModel interestsViewModel;
    AppDataManager appDataManager = new AppDataManager();

//    private void setText() {
//        new Test(BoardTitle.일반공지).execute(21745);
//    }
//
//    private void process(String s) {
//
//    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FragmentInterestsBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_interests, container, false);
        Content content = appDataManager.getContents(BoardTitle.일반공지, 21745).get(0);
        binding.setTestA(content);
        View root = binding.getRoot();

        return root;
    }
}