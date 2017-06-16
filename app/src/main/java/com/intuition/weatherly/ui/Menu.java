package com.intuition.weatherly.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.intuition.weatherly.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu extends Fragment {

    public Menu () {}

    @BindView(R.id.weatherMenu)    ImageView mWeatherMenu;
    @BindView(R.id.weatherAddCity) ImageView mWeatherAddCity;
    @BindView(R.id.weatherFav) ImageView mWeatherFav;
    @BindView(R.id.weatherHomeCity) ImageView mWeatherHomeCity;
    @BindView(R.id.weatherLogout) ImageView mWeatherLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.fragment_menu, parent, false);

    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ButterKnife.bind(view);
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);
    }
}