package com.kritikaprasher.newsaggregator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

/**
 * Created by pranavprashar on 4/4/17.
 */

public class dataFragment extends Fragment {
    View view;
    ViewPager ViewPager;
    TabLayout TabLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.sample, container, false);

        ViewPager= (ViewPager)view.findViewById(R.id.ViewPager);
        ViewPager.setAdapter(new slideAdapter (getChildFragmentManager()));
        TabLayout= (TabLayout)view.findViewById(R.id.TabLayout);
        TabLayout.post(new Runnable() {
            @Override
            public void run() {
                TabLayout.setupWithViewPager(ViewPager);
            }
        });


        return view;
    }
    private class slideAdapter extends FragmentPagerAdapter {

        final String tabs[]= {"tab1","tab2"};

        public slideAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new contentFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }

        //public CharSequence getPageTitle(int position){
            //return tabs(position);
        }
    }

