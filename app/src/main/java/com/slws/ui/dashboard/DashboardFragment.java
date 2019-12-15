package com.slws.ui.dashboard;

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
import com.slws.databinding.FragmentDashboardBinding;
import com.slws.utils.BoardTitle;


public class DashboardFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDashboardBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);

        FragmentPagerAdapter tabsPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            @Override
            public int getItemPosition(@NonNull Object object) {
                return super.getItemPosition(object);
            }

            @Override
            public Fragment getItem(int position) {
                return ContentFragment.newInstance(BoardTitle.BOARD_TITLES.get(position));
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return BoardTitle.BOARD_TITLES.get(position).toString();
            }

            @Override
            public int getCount() {
                return BoardTitle.BOARD_TITLES.size();
            }
        };

        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(tabsPagerAdapter);
        binding.tabLayout.setupWithViewPager(viewPager);

        return binding.getRoot();
    }

}