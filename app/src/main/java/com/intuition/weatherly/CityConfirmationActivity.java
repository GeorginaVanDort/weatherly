package com.intuition.weatherly;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CityConfirmationActivity extends AppCompatActivity {

    private String[] possibleCities = new String[] {"the United Kingdom", "Arkansas",
            "Connecticut", "Indiana", "Maine", "Michigan", "Missouri", "North Dakota",
            "New York", "Ohio", "Oregon", "Pennsylvania", "Tennessee", "Texas",
            "Victoria, Australia"};

//    private String[] cityAlts = new String[] {"Portland Mills, PA", "Portlandville, NY"};

    @BindView(R.id.cityListView) ListView mCityListView;
    @BindView(R.id.chooseCityText) TextView mChooseCityText;
    @BindView(R.id.cityInputResult) TextView mCityInputResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_confirmation);

        ButterKnife.bind(this);
        Typeface pacifico = Typeface.createFromAsset(getAssets(),"fonts/pacifico.ttf");
        mCityInputResult.setTypeface(pacifico);
        mChooseCityText.setTypeface(pacifico);

        mCityListView.setAdapter(new CityArrayAdapter(this, android.R.layout.simple_list_item_1, possibleCities));

        Intent intent = getIntent();
        String city = intent.getStringExtra("city");
        mCityInputResult.setText(city);

        mCityListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String state = possibleCities[position].toString();
                Toast.makeText(CityConfirmationActivity.this, "Portland " + state, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
