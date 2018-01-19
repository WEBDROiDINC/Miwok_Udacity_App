package com.example.android.miwok;

import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Blood_seeker on 1/19/2018.
 */


import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimplePagerAdaptor extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Numbers","Colors","Phrases","Family"};

    public SimplePagerAdaptor(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1){
            return new ColorsFragment();
        } else if (position == 2){
            return new PhrasesFragment();
        }
        else                     {
            return new FamilyFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }



    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}