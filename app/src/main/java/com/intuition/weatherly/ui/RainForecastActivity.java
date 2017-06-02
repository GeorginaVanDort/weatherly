package com.intuition.weatherly.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.intuition.weatherly.R;
import com.intuition.weatherly.adapters.RainForecastAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RainForecastActivity extends AppCompatActivity {

    @BindView(R.id.rainListView) ListView mRainListView;


    String[] timeIntervals = new String[] {
            "3.45pm", "3.50pm", "3.55pm", "4.00pm", "4.05pm", "4.10pm", "4.15pm", "4.20pm"
    };

    String[] rainSummary = new String[] { "Light Rain", "Light Rain", "Light Rain",
            "Moderate Rain", "Moderate Rain", "Moderate Rain", "Hail", "Hail"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rain_forecast);

        //Bind Views and set Font//
        ButterKnife.bind(this);
        mRainListView.setAdapter(new RainForecastAdapter(this, timeIntervals, rainSummary));
    }
}
