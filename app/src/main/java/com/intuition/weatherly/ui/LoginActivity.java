package com.intuition.weatherly.ui;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.intuition.weatherly.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.loginButt) TextView mLoginButt;
    @BindView(R.id.loginEmail) TextView mLoginEmail;
    @BindView(R.id.loginPass) TextView mLoginPassword;
    @BindView(R.id.loginOk) TextView mLoginOk;
    @BindView(R.id.createAccountButt) TextView mCreateAccButt;
    @BindView(R.id.createName) TextView mCreateName;
    @BindView(R.id.createEmail) TextView mCreateEmail;
    @BindView(R.id.createPass) TextView mCreatePassword;
    @BindView(R.id.createPassConf) TextView mCreatePasswordConf;
    @BindView(R.id.createAccOk) TextView mCreateAccOk;
    @BindView(R.id.accViewGroup) LinearLayout mAccViewGroup;
    @BindView(R.id.loginViewGroup) LinearLayout mLoginViewGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        Typeface leck = Typeface.createFromAsset(getAssets(),"fonts/leck.ttf");
        mLoginButt.setTypeface(leck);
        mCreateAccButt.setTypeface(leck);

        mLoginButt.setOnClickListener(this);
        mCreateAccButt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButt) {
            slideToBottom(mLoginViewGroup);
            mAccViewGroup.clearAnimation();
            mAccViewGroup.setVisibility(View.GONE);
        }

        if (v == mCreateAccButt) {
            slideToBottom(mAccViewGroup);
            mLoginViewGroup.clearAnimation();
            mLoginViewGroup.setVisibility(View.GONE);
        }
    }

    public void slideToBottom(View view){
        if (view.getVisibility()==View.GONE) {
            TranslateAnimation animate = new TranslateAnimation(0,0,-100,45);
            animate.setDuration(500);
            animate.setFillAfter(true);
            view.startAnimation(animate);
            view.setVisibility(View.VISIBLE);
        } else {
            TranslateAnimation animate = new TranslateAnimation(0,0,0,-45);
            animate.setDuration(500);
            animate.setFillAfter(true);
            view.startAnimation(animate);
            view.clearAnimation();
            view.setVisibility(View.GONE);
        }
    }
}
