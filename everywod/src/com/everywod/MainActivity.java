package com.everywod;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

	AppSectionsPagerAdapter appSectionsPagerAdapter;
	ViewPager viewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		final ActionBar actionBar = getActionBar();
//		actionBar.setHomeButtonEnabled(false);
//
//		appSectionsPagerAdapter = new AppSectionsPagerAdapter(getSupportFragmentManager());
//		viewPager = (ViewPager)findViewById(R.id.pager);
//		viewPager.setAdapter(appSectionsPagerAdapter);
//		viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
//			@Override
//			public void onPageSelected(int position) {
//				actionBar.setSelectedNavigationItem(position);
//
//				//super.onPageSelected(position);
//			}
//		});
		
//		actionBar.addTab(actionBar.newTab()
//				.setText("Navigation")
//				.setTabListener(this));
//
//		actionBar.addTab(actionBar.newTab()
//				.setText("Dashboard")
//				.setTabListener(this));
//
//		actionBar.addTab(actionBar.newTab()
//				.setText("Search")
//				.setTabListener(this));
		
		
	}
	
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {		
	}
	
	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		viewPager.setCurrentItem(arg0.getPosition());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	

}
