package com.cvcompany.vo.myapplication.View.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cvcompany.vo.myapplication.View.Fragment.InputImage;
import com.cvcompany.vo.myapplication.View.Fragment.LoadImage;

/**
 * Created by vinh on 8/23/2017.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    public MyViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment  = null;
        switch (position){
            case 0: fragment = new InputImage();
                return fragment;
            case 1: fragment = new LoadImage();
                return fragment;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }


}
