package com.sifiso.codetribe.dvs.doctorlib.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by CodeTribe1 on 2014-12-10.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> list;

    public PagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    @Override
    public Fragment getItem(int i) {

        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "Title";

        switch (position) {
            case 0:
                title = "Visits";
                break;
            case 1:
                title = "PatientFiles";
                break;
            default:
                break;
        }
        return title;
    }
}