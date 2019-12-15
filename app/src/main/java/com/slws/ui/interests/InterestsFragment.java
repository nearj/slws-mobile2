package com.slws.ui.interests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.slws.R;
import com.slws.data.AppDataManager;
import com.slws.databinding.FragmentInterestsBinding;


public class InterestsFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        FragmentInterestsBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_interests, container, false);

        FragmentPagerAdapter tabPageAdapter =
                new FragmentPagerAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
                    @Override
                    public int getCount() {
                        return 3;
                    }

                    @NonNull
                    @Override
                    public Fragment getItem(int position) {
                        switch (position) {
                            case 0:
                                return new InterestContentFragment(AppDataManager.getLists());
                            case 1:
                                return new InterestContentFragment(AppDataManager.getDoneList(true));
                            case 2:
                                return new InterestContentFragment(AppDataManager.getDoneList(false));
                            default:
                                return null;
                        }
                    }

                    @Nullable
                    @Override
                    public CharSequence getPageTitle(int position) {
                        return new String[]{"전체보기", "완료목록", "진행목록"}[position];
                    }

                };
        ViewPager viewPager = binding.viewPagerInterest;
        viewPager.setAdapter(tabPageAdapter);
        binding.tabLayoutInterest.setupWithViewPager(viewPager);

        return binding.getRoot();
    }


}