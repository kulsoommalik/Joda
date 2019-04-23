package com.example.jora_shoppingapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Timer;
import java.util.TimerTask;

import static android.support.constraint.Constraints.TAG;


public class Home extends Fragment {
    ViewPager mViewPager;
    ImageAdapter adapterView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

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

        //gettingPictures();

        db.collection("HomeSlider")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("here", document.getId());
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });

        return view;

    }


    private void gettingPictures(){
        //images from firbase
        db.collection("HomeSlider")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("here", document.getId());
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        }
                        else {
                            Log.w(TAG, "Error getting documents");
                        }
                    }
                });
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
