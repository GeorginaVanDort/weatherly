package com.intuition.weatherly.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.intuition.weatherly.R;
import com.intuition.weatherly.adapters.RainForecastAdapter;
import com.intuition.weatherly.models.RainForecast;
import com.intuition.weatherly.models.WeatherForecast;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RainForecastActivity extends AppCompatActivity {
    public static final String TAG = RainForecastActivity.class.getSimpleName();

    @BindView(R.id.rainRecyclerView) RecyclerView mRainListView;
    private RainForecastAdapter mAdapter;
    public ArrayList<RainForecast> mRainForecasts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain_forecast);

        //Bind Views and set Font//
        ButterKnife.bind(this);
        mRainForecasts = Parcels.unwrap(getIntent().getParcelableExtra("rain"));

        mAdapter = new RainForecastAdapter(getApplicationContext(), mRainForecasts);
        mRainListView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(RainForecastActivity.this);
        mRainListView.setLayoutManager(layoutManager);
        mRainListView.setHasFixedSize(true);
    }
}
