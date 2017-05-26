package com.intuition.weatherly;


import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

public class CityArrayAdapter extends ArrayAdapter{
    private String[] mStateList;

    public CityArrayAdapter(@NonNull Context context, @LayoutRes int resource, String[] mStateList) {
        super(context, resource);
        this.mStateList = mStateList;
    }

    @Override
    public Object getItem(int position){
        String state = mStateList[position];
        return "Portland, in " + state + "?";
    }

    @Override
    public int getCount() {
        return mStateList.length;
    }
}
