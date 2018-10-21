package com.ismusic.Adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private String[] tabTitleArray;

    private List<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(FragmentManager fm, Context context, List fragmentList, String[] tabTitleArray) {
        super(fm);
        this.tabTitleArray =tabTitleArray;
        this.fragmentList = fragmentList;
    }


    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return tabTitleArray.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitleArray[position%tabTitleArray.length];
    }
}
