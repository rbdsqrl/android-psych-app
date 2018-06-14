package com.rbdsqrl.mindsafe.view;

import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rbdsqrl.mindsafe.R;
import com.rbdsqrl.mindsafe.databinding.ActivityHomeBinding;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class HomeActivity extends BaseActivity {

    FragmentManager fragmentManager;
    ActivityHomeBinding homeBinding;

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public void onLayoutReady() {
        homeBinding = DataBindingUtil.setContentView(this, getLayout());
        fragmentManager = getSupportFragmentManager();
        setHomeScreen();
        homeBinding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        homeBinding.navigation.setSelectedItemId(R.id.navigation_home);
    }

    private void setHomeScreen() {
        Fragment fragment = new DiaryFragment();
        fragmentManager.beginTransaction().add(R.id.frameLayout, fragment).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new DiaryFragment();
                    break;
                case R.id.navigation_stories:
                    fragment = new StoriesFragment();
                    break;
                case R.id.navigation_timeline:
                    fragment = new TimelineFragment();
                    break;
                case R.id.navigation_more:
                    fragment = new MoreFragment();
                    break;
                default:
                    return false;
            }
            fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit();
            return true;
        }
    };
}
