package com.designskill.telemedicine.viewpager;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.designskill.telemedicine.fragment.MyAppointmentPagerFragment;

/**
 * Created by abdalla on 2/18/18.
 */

public class MyappointmetViewPager extends FragmentPagerAdapter {

    private int numOfTabs;


    public MyappointmetViewPager(FragmentManager fm, int tabCount) {
        super(fm);
        this.numOfTabs = tabCount;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MyAppointmentPagerFragment("Upcoming");

            case 1:
                return new MyAppointmentPagerFragment("Past");


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
