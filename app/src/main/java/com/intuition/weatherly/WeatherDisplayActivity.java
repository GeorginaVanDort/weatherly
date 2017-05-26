package com.intuition.weatherly;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WeatherDisplayActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.cityTextView) TextView mCityTextView;
    @BindView(R.id.temp_text_view) TextView mTempTextView;
    @BindView(R.id.summaryText) TextView mSummaryText;
    @BindView(R.id.getRainText) TextView mGetRainText;
    @BindView(R.id.timeLabel) TextView mTimeLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_display);

        //Bind Views and set fonts//
        ButterKnife.bind(this);
        Typeface pacifico = Typeface.createFromAsset(getAssets(),"fonts/pacifico.ttf");
        mCityTextView.setTypeface(pacifico);
        mSummaryText.setTypeface(pacifico);
        mGetRainText.setTypeface(pacifico);
        mTimeLabel.setTypeface(pacifico);

        //Get data from intent//
        Intent intent = getIntent();
        String city = intent.getStringExtra("cityFinal");
        mCityTextView.setText(city);

        //Set onclick listener//
        mGetRainText.setOnClickListener(this);
    }

    //Define onclick//
    @Override
    public void onClick(View v) {
        if (v == mGetRainText) {
            Intent intent  = new Intent(WeatherDisplayActivity.this, RainForecastActivity.class);
            intent.putExtra("city", mCityTextView.getText().toString());
            startActivity(intent);
        }
    }
}
