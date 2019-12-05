package com.example.slws.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.slws.R;
import com.google.android.material.tabs.TabLayout;

import java.lang.ref.WeakReference;
import java.util.Hashtable;


public class DashboardActivity extends AppCompatActivity {
    private ContactsFragment contactsFragment;
    private RecentsFragment recentsFragment;
    private SpeedDialFragment speedDialFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(this, getSupportFragmentManager());
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        TabLayout.Tab tab = tabLayout.newTab();
        tabLayout.addTab(tabLayout.newTab().setText("일반 공지"));
        tabLayout.addTab(tabLayout.newTab().setText("학사 공지"));
        tabLayout.addTab(tabLayout.newTab().setText("직원 채용"));
        tabLayout.addTab(tabLayout.newTab().setText("창업 공지"));
        tabLayout.addTab(tabLayout.newTab().setText("입찰 공고"));
        tabLayout.addTab(tabLayout.newTab().setText("시설 공사"));
        tabLayout.addTab(tabLayout.newTab().setText("행사 안내"));
        tabLayout.addTab(tabLayout.newTab().setText("비교과 교육"));
        /*
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(tabsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
*/
    }

    private class TabsPagerAdapter extends FragmentPagerAdapter {
        private final Context mContext;
        protected Hashtable<Integer, WeakReference<Fragment>> fragmentReferences;

        public TabsPagerAdapter(Context context, FragmentManager fm) {
            super(fm);
            mContext = context;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new RecentsFragment();
                case 1:
                    return new ContactsFragment();
                case 2:
                    return new SpeedDialFragment();
                default:
                    return null;
            }
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Fragment createdFragment = (Fragment) super.instantiateItem(container, position);
            switch (position) {
                case 0:
                    contactsFragment = (ContactsFragment) createdFragment;
                    break;
                case 1:
                    recentsFragment = (RecentsFragment) createdFragment;
                    break;
                case 2:
                    speedDialFragment = (SpeedDialFragment) createdFragment;
                    break;
            }
            return createdFragment;
        }


        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }
}