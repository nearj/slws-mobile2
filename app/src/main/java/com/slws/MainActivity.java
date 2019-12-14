package com.slws;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.slws.ui.dashboard.DashboardActivity;
import com.slws.ui.home.HomeFragment;
import com.slws.ui.interests.InterestsFragment;
import com.slws.ui.keyword.KeywordFragment;

public class MainActivity extends AppCompatActivity {

    final Fragment mHomeFragment = new HomeFragment();
    final Fragment mInterestFragment = new InterestsFragment();
    final Fragment mKeywordFragment = new KeywordFragment();

    final Activity mDashBoardActivitiy = new DashboardActivity();

    final FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment activeFragment = mHomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_keyword, R.id.navigation_notifications)
                .build();
//        navView.setOnNavigationItemSelectedListener((MenuItem menuItem) -> {
//            switch (menuItem.getItemId()) {
//                case R.id.navigation_home:
//                    fragmentManager.beginTransaction().hide(activeFragment).show(mHomeFragment).commit();
//                    activeFragment = mHomeFragment;
//                case R.id.navigation_dashboard:
//                    fragmentManager.beginTransaction().hide(activeFragment).show()
//
//            }
//            return false;
//        });

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_dashboard:
                Intent i = new Intent(MainActivity.this, DashboardActivity.class);
                MainActivity.this.startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


}
