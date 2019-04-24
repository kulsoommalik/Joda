package com.example.jora_shoppingapp;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Toolbar mainToolBar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private TabsAccessAdaptor tabsAccessAdaptor;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mainToolBar = (Toolbar) findViewById(R.id.main_page_toolbar);
//        setSupportActionBar(mainToolBar);
//        getSupportActionBar().setTitle(" ");
//        getSupportActionBar().setIcon(R.drawable.logo);


        viewPager = (ViewPager) findViewById(R.id.main_tabs_pager);
        tabsAccessAdaptor = new TabsAccessAdaptor (getSupportFragmentManager());
        viewPager.setAdapter(tabsAccessAdaptor);

        tabLayout = (TabLayout) findViewById(R.id.main_tabs);
        tabLayout.setupWithViewPager(viewPager);

        //setting icon of each fragment in tab
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            if(i == 0){
                tabLayout.getTabAt(i).setIcon(R.drawable.home);
            }
            else if(i == 1){
                tabLayout.getTabAt(i).setIcon(R.drawable.category);
            }
            else if(i == 2){
                tabLayout.getTabAt(i).setIcon(R.drawable.cart);
            }
            else if(i == 3){
                tabLayout.getTabAt(i).setIcon(R.drawable.services);
            }
        }
        //-----------------------------------------

    }

}
