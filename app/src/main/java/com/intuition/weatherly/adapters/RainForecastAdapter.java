package com.intuition.weatherly.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.intuition.weatherly.R;
import com.intuition.weatherly.models.RainForecast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RainForecastAdapter extends RecyclerView.Adapter<RainForecastAdapter.RainForecastViewHolder> {
    private Context mContext;
    private ArrayList<RainForecast> mRainForecasts;

    public RainForecastAdapter(Context context, ArrayList<RainForecast> rainForecasts) {
        mContext = context;
        mRainForecasts = rainForecasts;
    }

    @Override
    public RainForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rain_forecast_item, parent, false);
        RainForecastViewHolder viewHolder = new RainForecastViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RainForecastViewHolder holder, int position) {
        holder.bindRainForecast(mRainForecasts.get(position));

    }

    @Override
    public int getItemCount() {
        return mRainForecasts.size();
    }

    public class RainForecastViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rainSummaryLabel) TextView mRainSummaryLabel;
        @BindView(R.id.rainTimeLabel) TextView mRainTimeLabel;
        @BindView(R.id.rainIconImageView) ImageView mRainIconImageView;

        private Context mContext;

        public RainForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRainForecast(RainForecast rainForecast) {
            mRainTimeLabel.setText(rainForecast.getRealTime());
            mRainSummaryLabel.setText(rainForecast.getRainDescription());
        }
    }


//    @Override
//    public int getCount() {
//        return 8;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View listView;
//        if (convertView == null) {
//            listView = inflater.inflate(R.layout.rain_forecast_item, null);
//            TextView rainTimeLabel = (TextView) listView.findViewById(R.id.rainTimeLabel);
//            TextView rainSummaryLabel = (TextView) listView.findViewById(R.id.rainSummaryLabel);
//            rainTimeLabel.setText(mTimes[position]);
//            rainSummaryLabel.setText(mSummary[position]);
//        } else {
//            listView = (View) convertView;
//        }
//        return listView;
//    }
}
