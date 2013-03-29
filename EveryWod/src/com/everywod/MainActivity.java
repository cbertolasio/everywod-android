package com.everywod;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.slidingmenu.lib.SlidingMenu;

public class MainActivity extends BaseActivity {

    public MainActivity() {
        super(R.string.dashboard);
    }


    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        ViewPager vp = new ViewPager(this);
        vp.setId("VP".hashCode());
        vp.setAdapter(new DashboardPagerAdapter(getSupportFragmentManager()));

        setContentView(vp);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int arg0) { }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) { }

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

        vp.setCurrentItem(0);
        getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
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
