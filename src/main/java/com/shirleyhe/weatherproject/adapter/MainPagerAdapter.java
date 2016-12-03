package com.shirleyhe.weatherproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.shirleyhe.weatherproject.fragment.DetailsFragment;
import com.shirleyhe.weatherproject.fragment.MainInfoFragment;

/**
 * Created by shirleyhe on 12/2/16.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {


    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainInfoFragment();
            case 1:
                return new DetailsFragment();
            default:
                return new MainInfoFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Main";
            case 1:
                return "Details";
            default:
                return "Main";
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
