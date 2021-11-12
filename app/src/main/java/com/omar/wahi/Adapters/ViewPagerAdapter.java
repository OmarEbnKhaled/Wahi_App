package com.omar.wahi.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.omar.wahi.Fragment.Home_Fragment;
import com.omar.wahi.Fragment.Honor_Fragment;
import com.omar.wahi.Fragment.Profile_Fragment;
import com.omar.wahi.Fragment.Teachers_Fragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new Home_Fragment();

            case 1:
                return new Teachers_Fragment();

            case 2:
                return new Honor_Fragment();

            case 3:
                return new Profile_Fragment();

            default:
                return new Home_Fragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
