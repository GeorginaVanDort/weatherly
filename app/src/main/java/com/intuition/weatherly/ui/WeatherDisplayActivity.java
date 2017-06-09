package com.intuition.weatherly.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.intuition.weatherly.R;
import com.intuition.weatherly.models.RainForecast;
import com.intuition.weatherly.models.WeatherForecast;
import com.intuition.weatherly.services.ForecastService;

import org.parceler.Parcels;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherDisplayActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = WeatherDisplayActivity.class.getSimpleName();

    private WeatherForecast mForecast;
    Double mLatitude;
    Double mLongitude;

    @BindView(R.id.cityTextView) TextView mCityTextView;
    @BindView(R.id.temp_text_view) TextView mTempTextView;
    @BindView(R.id.summaryText) TextView mSummaryText;
    @BindView(R.id.getRainText) TextView mGetRainText;
    @BindView(R.id.timeLabel) TextView mTimeLabel;
    @BindView(R.id.degreesTextView) TextView mDegrees;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_display);

        //Bind Views and set fonts//
        ButterKnife.bind(this);
        Typeface lato = Typeface.createFromAsset(getAssets(),"fonts/lato.ttf");
        Typeface bubbler = Typeface.createFromAsset(getAssets(),"fonts/breeze.ttf");
        Typeface latoh = Typeface.createFromAsset(getAssets(),"fonts/latoh.ttf");
        Typeface weather = Typeface.createFromAsset(getAssets(),"fonts/weather.ttf");


        mCityTextView.setTypeface(bubbler);
        mSummaryText.setTypeface(bubbler);
        mGetRainText.setTypeface(weather);
        mTimeLabel.setTypeface(latoh);
        mTempTextView.setTypeface(lato);
        mDegrees.setTypeface(lato);


        //Get data from intent//
        Intent intent = getIntent();
        String city = intent.getStringExtra("cityFinal");
        mCityTextView.setText(city);

        //get lat/long//
        if (city.toString().equals("Hong Kong")) {
            mLongitude = 114.173870;
            mLatitude = 22.293067;
        }if (city.toString().equals("Melbourne")) {
            mLongitude =144.963058;
            mLatitude = -37.813628;
        }if (city.toString().equals("Paris")) {
            mLongitude = 2.352222;
            mLatitude = 48.856614;
        }if (city.toString().equals("London")) {
            mLongitude = -0.127758;
            mLatitude = 51.507351;
        }if (city.toString().equals("Beijing")) {
            mLongitude = 116.407396;
            mLatitude = 39.904200;
        }if (city.toString().equals("Kyoto")) {
            mLongitude = 135.768029;
            mLatitude = 35.011636;
        }if (city.toString().equals("Vancouver BC")) {
            mLongitude = -123.120738;
            mLatitude = 49.282729;
        }if (city.toString().equals("New York")) {
            mLongitude = -74.005941;
            mLatitude = 40.712784;
        }if (city.toString().equals("Portland")) {
            mLongitude = -122.676482;
            mLatitude = 45.523062;
        }


        //Make api call//
        ForecastService.getForecast(mLatitude, mLongitude, new Callback() {

            //On Failure//
            @Override
            public void onFailure(Call call, IOException e) { e.printStackTrace();
            }

            //On Response//
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Process Response Data//
                mForecast = ForecastService.processResults(response);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTempTextView.setText(mForecast.getTemp());
                        mSummaryText.setText(mForecast.getSummary());
                        mTimeLabel.setText(mForecast.getRealTime());
                        if (mForecast.getRainForecasts()==null){
                            mGetRainText.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });


        //Set onclick listener//
        mGetRainText.setOnClickListener(this);
        mCityTextView.setOnClickListener(this);
    }

    //Define onclick//
    @Override
    public void onClick(View v) {
        if (v == mGetRainText) {
            Intent intent  = new Intent(WeatherDisplayActivity.this, RainForecastActivity.class);
            ArrayList<RainForecast> rainForecasts = mForecast.getRainForecasts();
            intent.putExtra("rain", Parcels.wrap(rainForecasts));
            startActivity(intent);
        }
        if (v == mCityTextView){
            Intent mapIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("geo:" + mLatitude
                            + "," + mLongitude
                    ));
            startActivity(mapIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        if (id == R.id.add_city) {
            Intent intent = new Intent(WeatherDisplayActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(WeatherDisplayActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
