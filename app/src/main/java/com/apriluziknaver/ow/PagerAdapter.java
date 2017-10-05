package com.apriluziknaver.ow;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mapri on 2017-10-02.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    Fragment[] frags = new Fragment[2];



    public PagerAdapter(FragmentManager fm) {
        super(fm);

        frags[0] = new Pager1Fragment();
        frags[1] = new Pager2Fragment();

    }

    @Override
    public Fragment getItem(int position) {
        return frags[position];
    }

    @Override
    public int getCount() {
        return frags.length;
    }
}
