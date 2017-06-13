package com.intuition.weatherly.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.intuition.weatherly.Constants;
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
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


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

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Menu onClicks//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        if (id == R.id.add_city) {
            Intent intent = new Intent(RainForecastActivity.this, MainActivity.class);
            startActivity(intent);
            mEditor.putString(Constants.PREFERENCES_NEW_CITY, "true").apply();
        }
        if (id == R.id.saved_locs) {
            Intent intent = new Intent(RainForecastActivity.this, FavoriteLocationsActivity.class);
            startActivity(intent);
        }
        if (id == R.id.home_city) {
            mEditor.putString(Constants.PREFERENCES_NEW_CITY, "").apply();
            Intent intent = new Intent(RainForecastActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(RainForecastActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
