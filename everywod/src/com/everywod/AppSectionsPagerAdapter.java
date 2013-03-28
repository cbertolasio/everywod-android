package com.everywod;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class AppSectionsPagerAdapter extends FragmentPagerAdapter {

	public AppSectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {
		case 0:
			return new SearchFragment();
		case 1:
			return new DeckNavigationFragment();
		default:
			return new DashboardFragment();
			
		}
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
}
