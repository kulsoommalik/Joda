package com.example.jora_shoppingapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Timer;
import java.util.TimerTask;


public class Home extends Fragment {
    ViewPager mViewPager;
    ImageAdapter adapterView;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new SliderTimer(), 4000, 6000);

        mViewPager = view.findViewById(R.id.img_slider);
        adapterView = new ImageAdapter(this.getActivity()); //getActivity for context
        mViewPager.setAdapter(adapterView);

        return view;

    }
    private class SliderTimer extends TimerTask {
        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mViewPager.getCurrentItem() == 0) {
                        mViewPager.setCurrentItem(1);
                    }
                    else if (mViewPager.getCurrentItem() == 1) {
                        mViewPager.setCurrentItem(2);
                    }
                    else if (mViewPager.getCurrentItem() == 2) {
                        mViewPager.setCurrentItem(3);
                    }
                    else{
                        mViewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }
}
