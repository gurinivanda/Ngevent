package com.kelompok03.amikomngevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kelompok03.amikomngevent.BnvFragment.DashboardFragment;
import com.kelompok03.amikomngevent.BnvFragment.DashboardPager.LatestEventFragment;
import com.kelompok03.amikomngevent.BnvFragment.NotificationFragment;
import com.kelompok03.amikomngevent.BnvFragment.ProfileFragment;

public class MainActivity extends AppCompatActivity{
    BottomNavigationView bnvHome;

    DashboardFragment dashboardFragment;
    NotificationFragment notificationFragment;
    ProfileFragment profileFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dashboardFragment = new DashboardFragment();
        notificationFragment = new NotificationFragment();
        profileFragment = new ProfileFragment();

        switchFrag(dashboardFragment);

        bnvHome = findViewById(R.id.bnvMain);
        bnvHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.mDashboard:
                        dashboardFragment = new DashboardFragment();
                        switchFrag(dashboardFragment);
                        break;
                    case R.id.mNotif:
                        switchFrag(notificationFragment);
                        break;
                    case R.id.mProfile:
                        switchFrag(profileFragment);
                        break;
                }
                return true;
            }
        });
    }

    private void switchFrag (Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameMain, fragment)
                .commit();
    }


}
