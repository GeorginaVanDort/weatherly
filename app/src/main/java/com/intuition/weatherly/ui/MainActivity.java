package com.intuition.weatherly.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.intuition.weatherly.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.appTitle) TextView mAppTitle;
    @BindView(R.id.enterCityText) TextView mEnterCityText;
    @BindView(R.id.cityInput) EditText mCityInput;
    @BindView(R.id.addCityButton) Button mAddCityButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Views and set fonts//
        ButterKnife.bind(this);
        Typeface pacifico = Typeface.createFromAsset(getAssets(),"fonts/pacifico.ttf");
        mAppTitle.setTypeface(pacifico);
        mEnterCityText.setTypeface(pacifico);

        //Set onclick listener//
        mAddCityButton.setOnClickListener(this);

    }

    //Define onclick//
    @Override
    public void onClick(View v) {
        if (v == mAddCityButton) {
            String city = mCityInput.getText().toString();

            //validate input//
            if (city == null || city.isEmpty()) {
                alertUser();
            }

            //get input and start next activity//
            else {
                Intent intent = new Intent(MainActivity.this, CityConfirmationActivity.class);
                intent.putExtra("city", city);
                startActivity(intent);
            }
        }
    }

    private void alertUser() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(),"Input a City");
    }
}
