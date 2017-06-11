package com.intuition.weatherly.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.intuition.weatherly.R;
import com.intuition.weatherly.adapters.CityArrayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityConfirmationActivity extends AppCompatActivity {

    private String[] possibleCities = new String[] {"the United Kingdom", "Arkansas",
            "Connecticut", "Indiana", "Maine", "Michigan", "Missouri", "North Dakota",
            "New York", "Ohio", "Oregon", "Pennsylvania", "Tennessee", "Texas",
            "Victoria, Australia"};

    @BindView(R.id.cityListView) ListView mCityListView;
    @BindView(R.id.chooseCityText) TextView mChooseCityText;
    @BindView(R.id.cityInputResult) TextView mCityInputResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_confirmation);

        //Bind Views and set fonts//
        ButterKnife.bind(this);
        Typeface pacifico = Typeface.createFromAsset(getAssets(),"fonts/breeze.ttf");
        mCityInputResult.setTypeface(pacifico);
        mChooseCityText.setTypeface(pacifico);

        Intent intent = getIntent();
        final String city = intent.getStringExtra("city");
        mCityInputResult.setText(city);

        mCityListView.setAdapter(new CityArrayAdapter(this, android.R.layout.simple_list_item_1, possibleCities, city));

        //Set onclick listener//
        mCityListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String state = possibleCities[position].toString();

                //Alert User//
                Toast.makeText(CityConfirmationActivity.this, city + ", " + state, Toast.LENGTH_SHORT).show();

                //Start next activity//
                Intent intent  = new Intent(CityConfirmationActivity.this, WeatherDisplayActivity.class);
                intent.putExtra("city", city);
                startActivity(intent);
            }
        });

    }
}
