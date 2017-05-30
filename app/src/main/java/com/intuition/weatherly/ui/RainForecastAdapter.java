package com.intuition.weatherly.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.intuition.weatherly.R;

public class RainForecastAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mTimes;
    private String[] mSummary;

    public RainForecastAdapter(Context context, String[] times, String[] summary) {
        this.mContext = context;
        this.mTimes = times;
        this.mSummary = summary;
    }


    @Override
    public int getCount() {
        return 8;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listView;
        if (convertView == null) {
            listView = inflater.inflate(R.layout.rain_forecast_item, null);
            TextView rainTimeLabel = (TextView) listView.findViewById(R.id.rainTimeLabel);
            TextView rainSummaryLabel = (TextView) listView.findViewById(R.id.rainSummaryLabel);
            rainTimeLabel.setText(mTimes[position]);
            rainSummaryLabel.setText(mSummary[position]);
        } else {
            listView = (View) convertView;
        }
        return listView;
    }
}
