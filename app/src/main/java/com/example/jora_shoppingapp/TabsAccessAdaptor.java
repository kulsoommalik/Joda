package com.example.jora_shoppingapp;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.ImageView;

public class TabsAccessAdaptor extends FragmentPagerAdapter {

    public TabsAccessAdaptor(FragmentManager fm) {
        super(fm);
    }

    Drawable myDrawable;
    String title;


    @Override
    public Fragment getItem(int i) {
        switch(i){

            case 0:
                Home home = new Home();
                return home;

            case 1:
                Category category = new Category();
                return category;

            case 2:
                Cart cart = new Cart();
                return cart;

            case 3:
                Services service = new Services();
                return service;

            default:
                return null;

        }

    }

    @Override
    public int getCount() {
        return 4;
    }


// title of fragments in tab
//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//
//        switch(position){
//
//            case 0:
//                return "Home";
//
//            case 1:
//                return "Category";
//
//            case 2:
//                return "Cart";
//
//            case 3:
//                return "Services";
//
//            default:
//                return null;
//
//        }
//    }


}
