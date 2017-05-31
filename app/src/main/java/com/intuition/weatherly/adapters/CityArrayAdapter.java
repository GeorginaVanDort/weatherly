package com.intuition.weatherly.adapters;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

public class CityArrayAdapter extends ArrayAdapter{
    private String[] mStateList;
    private String mCity;

    public CityArrayAdapter(@NonNull Context context, @LayoutRes int resource, String[] mStateList, String mCity) {
        super(context, resource);
        this.mStateList = mStateList;
        this.mCity = mCity;
    }

    @Override
    public Object getItem(int position){
        String state = mStateList[position];
        return mCity + ", in " + state + "?";
    }

    @Override
    public int getCount() {
        return mStateList.length;
    }
}
