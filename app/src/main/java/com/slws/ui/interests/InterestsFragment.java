package com.slws.ui.interests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.slws.R;

public class InterestsFragment extends Fragment {

    private InterestsViewModel interestsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        interestsViewModel =
                ViewModelProviders.of(this).get(InterestsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_interests, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        interestsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}