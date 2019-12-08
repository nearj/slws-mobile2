package com.slws.ui.dashboard;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.slws.R;


class TabsPagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;


    public TabsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        return new ContentFragment();
    }


    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getStringArray(R.array.notice_list)[position];
    }

    @Override
    public int getCount() {
        return mContext.getResources().getStringArray(R.array.notice_list).length;
    }
}
