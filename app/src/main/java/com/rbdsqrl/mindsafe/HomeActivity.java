package com.rbdsqrl.mindsafe;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rbdsqrl.mindsafe.databinding.ActivityHomeBinding;
import com.rbdsqrl.mindsafe.view.DiaryFragment;
import com.rbdsqrl.mindsafe.view.OverviewFragment;
import com.rbdsqrl.mindsafe.view.ProfileFragment;

import androidx.appcompat.app.AppCompatActivity;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActivityHomeBinding homeBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_home);
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
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragment = new DiaryFragment();
                    break;
                case R.id.navigation_profile:
                    fragment = new ProfileFragment();
                    break;
                case R.id.navigation_overview:
                    fragment = new OverviewFragment();
                    break;
                default:
                    return false;
            }
            fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit();
            return true;
        }
    };

}
