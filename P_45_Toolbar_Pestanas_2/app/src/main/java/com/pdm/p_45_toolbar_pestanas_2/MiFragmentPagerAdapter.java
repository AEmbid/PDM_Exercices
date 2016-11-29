package com.pdm.p_45_toolbar_pestanas_2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MiFragmentPagerAdapter extends FragmentPagerAdapter {
    private final String[] textosTab;

    public MiFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        textosTab = context.getResources().getStringArray(R.array.opciones);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch (position) {
            case 0:
                f = BlankFragment.newInstance(textosTab[position]);
                break;
            case 1:
                f = BlankFragment.newInstance(textosTab[position]);
                break;
            case 2:
                f = BlankFragment.newInstance(textosTab[position]);
                break;
        }
        return f;

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return textosTab[position];
    }

}
