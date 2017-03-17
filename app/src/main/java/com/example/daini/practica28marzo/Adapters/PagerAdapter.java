package com.example.daini.practica28marzo.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.daini.practica28marzo.Fragments.ScreenEnviar;
import com.example.daini.practica28marzo.Fragments.ScreenHistorial;

/**
 * Created by Daini on 15/03/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new ScreenEnviar();
                break;
            case 1:
                fragment = new ScreenHistorial();
                break;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
