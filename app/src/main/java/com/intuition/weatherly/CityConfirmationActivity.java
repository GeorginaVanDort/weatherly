package com.intuition.weatherly;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityConfirmationActivity extends AppCompatActivity {

    @BindView(R.id.cityListView) ListView mCityListView;
    @BindView(R.id.chooseCityText) TextView mChooseCityText;
    @BindView(R.id.cityInputResult) TextView mCityInputResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_confirmation);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        mCityInputResult.setText(city);

    }
}
