package com.kelompok03.amikomngevent.BnvFragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.google.android.material.tabs.TabLayout;
import com.kelompok03.amikomngevent.BnvFragment.DashboardPager.HomeFragment;
import com.kelompok03.amikomngevent.BnvFragment.DashboardPager.LatestEventFragment;
import com.kelompok03.amikomngevent.BnvFragment.DashboardPager.TabDashboardAdapter;
import com.kelompok03.amikomngevent.R;
import com.lapism.searchview.widget.SearchView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    SearchView searchView;
    RelativeLayout rlSearch;

    TabDashboardAdapter tabDashboardAdapter;

    HomeFragment homeFragment;
    LatestEventFragment latestEventFragment;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        homeFragment = new HomeFragment();
        latestEventFragment = new LatestEventFragment();
        tabDashboardAdapter = new TabDashboardAdapter(getChildFragmentManager());
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        searchView = view.findViewById(R.id.searchView);
        rlSearch = view.findViewById(R.id.rlSearch);

        searchView.setHint("Search Events");

        tabLayout.setupWithViewPager(viewPager);

        tabDashboardAdapter.addFrag(homeFragment, "HOME");
        tabDashboardAdapter.addFrag(latestEventFragment, "LATEST EVENT");

        viewPager.setAdapter(tabDashboardAdapter);
    }

}
