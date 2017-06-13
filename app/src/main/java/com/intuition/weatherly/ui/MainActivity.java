package com.intuition.weatherly.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.intuition.weatherly.Constants;
import com.intuition.weatherly.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mHomeLoc;
    private String mNewLoc;

    @BindView(R.id.appTitle) TextView mAppTitle;
    @BindView(R.id.enterCityText) TextView mEnterCityText;
    @BindView(R.id.addCityButton) Button mAddCityButton;
    @BindView(R.id.locSpinner) Spinner mLocspinner;
    @BindView(R.id.homeButton) Button mHomeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Views and set fonts//
        ButterKnife.bind(this);
        Typeface leck = Typeface.createFromAsset(getAssets(),"fonts/breeze.ttf");
        mAppTitle.setTypeface(leck);
        mEnterCityText.setTypeface(leck);
        mAddCityButton.setTypeface(leck);
        mHomeButton.setTypeface(leck);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mHomeLoc = mSharedPreferences.getString(Constants.PREFERENCES_SET_HOME, null);
        mNewLoc = mSharedPreferences.getString(Constants.PREFERENCES_NEW_CITY, null);


        if (mNewLoc == "" && mHomeLoc != null) {
            Intent intent = new Intent(MainActivity.this, WeatherDisplayActivity.class);
            intent.putExtra("city", mHomeLoc);
            mEditor.putString(Constants.PREFERENCES_NEW_CITY, "").apply();
            startActivity(intent);
        }

        //Set onclick listener//
        mAddCityButton.setOnClickListener(this);
        mHomeButton.setOnClickListener(this);
    }


    //Define onclick//
    @Override
    public void onClick(View v) {

        if (v == mAddCityButton) {
            String city = mLocspinner.getSelectedItem().toString();

            // /validate input//
            if (city == null || city.isEmpty()) {
                alertUser();
            }

            //get input and start next activity//
            else {
                Intent intent = new Intent(MainActivity.this, WeatherDisplayActivity.class);
                intent.putExtra("city", city);
                mEditor.putString(Constants.PREFERENCES_NEW_CITY, "").apply();
                startActivity(intent);
            }
        }

        if (v == mHomeButton) {
            String city = mLocspinner.getSelectedItem().toString();
            mEditor.putString(Constants.PREFERENCES_SET_HOME, city).apply();

            Intent intent = new Intent(MainActivity.this, WeatherDisplayActivity.class);
            intent.putExtra("city", city);
            mEditor.putString(Constants.PREFERENCES_NEW_CITY, "").apply();
            startActivity(intent);
        }
    }


    //create navbar menu//
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
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
            mEditor.putString(Constants.PREFERENCES_NEW_CITY, "true").apply();
        }
        if (id == R.id.saved_locs) {
            Intent intent = new Intent(MainActivity.this, FavoriteLocationsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void alertUser() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(),"Input a City");
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }
}
