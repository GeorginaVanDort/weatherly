package com.intuition.weatherly.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mLoginButt.setOnClickListener(this);
        mCreateAccButt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButt) {
            slideToBottom(mLoginEmail);
            slideToBottom(mLoginPassword);
            slideToBottom(mLoginOk);
        }

        if (v == mCreateAccButt) {
            slideToBottom(mCreateName);
            slideToBottom(mCreateEmail);
            slideToBottom(mCreatePassword);
            slideToBottom(mCreatePasswordConf);
            slideToBottom(mCreateAccOk);
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
