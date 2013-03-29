package com.everywod;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.actionbarsherlock.view.MenuItem;
import com.slidingmenu.lib.SlidingMenu;

public class MainActivity extends BaseActivity {

    private ViewPager viewPager;
    private int searchViewPosition = 1;
    private int dashboardViewPosition = 0;

    public MainActivity() {
        super(R.string.app_name);
    }


    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        viewPager = new ViewPager(this);
        viewPager.setId("VP".hashCode());
        viewPager.setAdapter(new DashboardPagerAdapter(getSupportFragmentManager()));

        setContentView(viewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) {
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                        break;
                    default:
                        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
                        break;
                }
            }

        });

        viewPager.setCurrentItem(dashboardViewPosition);
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.search:
                viewPager.setCurrentItem(searchViewPosition);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public class DashboardPagerAdapter extends  FragmentPagerAdapter {

        public DashboardPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 1:
                    return new SearchFragment();
                default:
                    return new DashboardFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }


}
