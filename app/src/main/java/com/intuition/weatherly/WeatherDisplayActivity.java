package com.intuition.weatherly;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherDisplayActivity extends AppCompatActivity {

    @BindView(R.id.cityTextView) TextView mCityTextView;
    @BindView(R.id.temp_text_view) TextView mTempTextView;
    @BindView(R.id.summaryText) TextView mSummaryText;
    @BindView(R.id.getRainText) TextView mGetRainText;
    @BindView(R.id.timeLabel) TextView mTimeLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_display);

        ButterKnife.bind(this);
        Typeface pacifico = Typeface.createFromAsset(getAssets(),"fonts/pacifico.ttf");
        mCityTextView.setTypeface(pacifico);
        mSummaryText.setTypeface(pacifico);
        mGetRainText.setTypeface(pacifico);
        mTimeLabel.setTypeface(pacifico);

        Intent intent = getIntent();
        String city = intent.getStringExtra("cityFinal");
        mCityTextView.setText(city);
    }
}
