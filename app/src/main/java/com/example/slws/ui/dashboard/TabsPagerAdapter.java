package com.example.slws.ui.dashboard;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.slws.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES =
            new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    private final Context mContext;
    protected Hashtable<Integer, WeakReference<Fragment>> fragmentReferences;

    public TabsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch(position) {
            case 0:
                fragment = new ContactsFragment();
                break;
            case 1:
                fragment = new RecentsFragment();
                break;

            default:
                fragment = new SpeedDialFragment();
                break;
        }

        fragmentReferences.put(position, new WeakReference(fragment));
        return fragment;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        WeakReference<Fragment> ref = fragmentReferences.get(position);
        return ref == null ? null : ref.get();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}
