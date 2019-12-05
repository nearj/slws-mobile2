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
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Hashtable;


public class DashboardActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        tabLayout = findViewById(R.id.tab_layout);
        TabLayout.Tab tab = tabLayout.newTab();
        tabLayout.addTab(tabLayout.newTab().setText("일반 공지"));
        tabLayout.addTab(tabLayout.newTab().setText("학사 공지"));
        tabLayout.addTab(tabLayout.newTab().setText("직원 채용"));
        tabLayout.addTab(tabLayout.newTab().setText("창업 공지"));
        tabLayout.addTab(tabLayout.newTab().setText("입찰 공고"));
        tabLayout.addTab(tabLayout.newTab().setText("시설 공사"));
        tabLayout.addTab(tabLayout.newTab().setText("행사 안내"));
        tabLayout.addTab(tabLayout.newTab().setText("비교과 교육"));

        viewPager = findViewById(R.id.view_pager);
        TabPagerAdapter pageAdapter = new TabPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //TabLayout tabs = findViewById(R.id.tabs);
        //tabs.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


}