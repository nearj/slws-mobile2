package com.slws.ui.dashboard;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.slws.utils.BoardTitle;


class TabsPagerAdapter extends FragmentPagerAdapter {
    private final Context mContext;


    public TabsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

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
//        return mContext.getResources().getStringArray(R.array.notice_list)[position];
    }

    @Override
    public int getCount() {
        return BoardTitle.BOARD_TITLES.size();
//        return mContext.getResources().getStringArray(R.array.notice_list).length;
    }
}
