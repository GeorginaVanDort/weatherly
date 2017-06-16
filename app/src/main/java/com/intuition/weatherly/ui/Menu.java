package com.intuition.weatherly.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.intuition.weatherly.Constants;
import com.intuition.weatherly.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Menu extends Fragment implements View.OnClickListener {



    public Menu () {}

    @BindView(R.id.weatherMenu)    ImageView mWeatherMenu;
    @BindView(R.id.weatherAddCity) ImageView mWeatherAddCity;
    @BindView(R.id.weatherFav) ImageView mWeatherFav;
    @BindView(R.id.weatherHomeCity) ImageView mWeatherHomeCity;
    @BindView(R.id.weatherLogout) ImageView mWeatherLogout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, parent, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        mWeatherMenu.setOnClickListener(this);
        mWeatherAddCity.setOnClickListener(this);
        mWeatherFav.setOnClickListener(this);
        mWeatherHomeCity.setOnClickListener(this);
        mWeatherLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SharedPreferences mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();

        if (v == mWeatherMenu) {
            slideOutLeft(mWeatherAddCity);
            slideOutDown1(mWeatherFav);
            slideOutDown2(mWeatherHomeCity);
            slideOutDown(mWeatherLogout);

        }
        if (v == mWeatherAddCity) {
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            mEditor.putString(Constants.PREFERENCES_NEW_CITY, "true").apply();
        }
        if (v == mWeatherFav) {
            Intent intent = new Intent(getActivity(), FavoriteLocationsActivity.class);
            startActivity(intent);
        }
        if (v == mWeatherHomeCity) {
            mEditor.putString(Constants.PREFERENCES_NEW_CITY, "").apply();
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        }
        if (v == mWeatherLogout) {
            logout();
        }
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish();
    }


    //  Motion Animation//
    public void slideOutLeft(View view){
        if (view.getVisibility()==View.GONE) {
            AnimationSet set = new AnimationSet(true);
            AlphaAnimation alpha = new AlphaAnimation(0,1);
            alpha.setDuration(500);
            alpha.setFillEnabled(true);
            alpha.setFillBefore(false);
            alpha.setFillAfter(false);
            set.addAnimation(alpha);

            TranslateAnimation animate = new TranslateAnimation(150,0,0,0);
            animate.setDuration(500);
            animate.setFillAfter(true);
            set.addAnimation(animate);
            view.startAnimation(set);
            view.setVisibility(View.VISIBLE);
        } else {
            view.clearAnimation();
            view.setVisibility(View.GONE);
        }
    }

    public void slideOutDown1(View view){
        if (view.getVisibility()==View.GONE) {
            AnimationSet set = new AnimationSet(true);
            AlphaAnimation alpha = new AlphaAnimation(0,1);
            alpha.setDuration(500);
            alpha.setFillEnabled(true);
            alpha.setFillBefore(false);
            alpha.setFillAfter(false);
            set.addAnimation(alpha);

            TranslateAnimation animate = new TranslateAnimation(100,0,-60,0);
            animate.setDuration(500);
            animate.setFillAfter(true);
            set.addAnimation(animate);
            view.startAnimation(set);
            view.setVisibility(View.VISIBLE);
        } else {
            view.clearAnimation();
            view.setVisibility(View.GONE);
        }
    }

    public void slideOutDown2(View view){
        if (view.getVisibility()==View.GONE) {
            AnimationSet set = new AnimationSet(true);
            AlphaAnimation alpha = new AlphaAnimation(0,1);
            alpha.setDuration(500);
            alpha.setFillEnabled(true);
            alpha.setFillBefore(false);
            alpha.setFillAfter(false);
            set.addAnimation(alpha);

            TranslateAnimation animate = new TranslateAnimation(60,0,-100,0);
            animate.setDuration(500);
            animate.setFillAfter(true);
            set.addAnimation(animate);
            view.startAnimation(set);
            view.setVisibility(View.VISIBLE);
        } else {
            view.clearAnimation();
            view.setVisibility(View.GONE);
        }
    }

    public void slideOutDown(View view){
        if (view.getVisibility()==View.GONE) {
            AnimationSet set = new AnimationSet(true);
            AlphaAnimation alpha = new AlphaAnimation(0,1);
            alpha.setDuration(500);
            alpha.setFillEnabled(true);
            alpha.setFillBefore(false);
            alpha.setFillAfter(false);
            set.addAnimation(alpha);

            TranslateAnimation animate = new TranslateAnimation(0,0,-150,0);
            animate.setDuration(500);
            animate.setFillAfter(true);
            set.addAnimation(animate);
            view.startAnimation(set);
            view.setVisibility(View.VISIBLE);
        } else {
            view.clearAnimation();
            view.setVisibility(View.GONE);
        }
    }
}