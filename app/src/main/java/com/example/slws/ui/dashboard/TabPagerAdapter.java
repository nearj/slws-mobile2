package com.example.slws.ui.dashboard;


import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.Fragment;

public class TabPagerAdapter extends FragmentStatePagerAdapter{
    private int tabCount;
    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                TabFragment1 tabFragment1 = new TabFragment1();
                return tabFragment1;
            case 1:
                TabFragment2 tabFragment2 = new TabFragment2();
                return tabFragment2;
            case 2:
                TabFragment3 tabFragment3 = new TabFragment3();
                return tabFragment3;
            case 3:
                TabFragment4 tabFragment4 = new TabFragment4();
                return tabFragment4;
            case 4:
                TabFragment5 tabFragment5 = new TabFragment5();
                return tabFragment5;
            case 5:
                TabFragment6 tabFragment6 = new TabFragment6();
                return tabFragment6;
            case 6:
                TabFragment7 tabFragment7 = new TabFragment7();
                return tabFragment7;
            case 7:
                TabFragment8 tabFragment8 = new TabFragment8();
                return tabFragment8;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
