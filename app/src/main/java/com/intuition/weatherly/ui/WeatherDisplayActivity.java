package com.intuition.weatherly.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.intuition.weatherly.R;
import com.intuition.weatherly.models.WeatherForecast;
import com.intuition.weatherly.services.ForecastService;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherDisplayActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = WeatherDisplayActivity.class.getSimpleName();

    private WeatherForecast mForecast;

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
        mCityTextView.setText("Portland");

        //Make api call//
        Double latitude = 45.5208;
        Double longitude = -122.6795;
        ForecastService.getForecast(latitude, longitude, new Callback() {

            //On Failure//
            @Override
            public void onFailure(Call call, IOException e) { e.printStackTrace();
            }

            //On Response//
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Process Response Data//
                mForecast = ForecastService.processResults(response);
                Log.v("HOIY!", mForecast.getSummary() + "");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTempTextView.setText(mForecast.getTemp());
                        mSummaryText.setText(mForecast.getSummary());
                        mTimeLabel.setText(mForecast.getRealTime());
                    }
                });
            }
        });


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
