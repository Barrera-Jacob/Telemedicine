package com.designskill.telemedicine.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.designskill.telemedicine.fragment.TopViewPagerFragmet;

/**
 * Created by abdalla on 2/18/18.
 */

public class TopViewPager extends FragmentPagerAdapter {

    private int numOfTabs;


    public TopViewPager(FragmentManager fm) {
        super(fm);
        this.numOfTabs = 3;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TopViewPagerFragmet();

            case 1:
                return new TopViewPagerFragmet();

            case 2:
                return new TopViewPagerFragmet();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
