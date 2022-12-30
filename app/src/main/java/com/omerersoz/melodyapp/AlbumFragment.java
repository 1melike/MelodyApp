package com.omerersoz.melodyapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AlbumFragment extends Fragment {

    //Kotlin üzerinden yazsanız daha temiz olabilirdi bence
    public AlbumFragment() {
        // Required empty public constructor
    }


    //Uygulamada hata yok gibi, sorunu öğrenebilir miyim?

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_album, container, false);
        return view;

    }
}