package com.intuition.weatherly.ui;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.intuition.weatherly.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;

    @BindView(R.id.loginButt) TextView mLoginButt;
    @BindView(R.id.loginEmail) TextView mLoginEmail;
    @BindView(R.id.loginPass) TextView mLoginPassword;
    @BindView(R.id.loginOk) TextView mLoginOk;
    @BindView(R.id.createAccountButt) TextView mCreateAccButt;
    @BindView(R.id.createName) TextView mCreateName;
    @BindView(R.id.createEmail) TextView mCreateEmail;
    @BindView(R.id.createPass) TextView mCreatePassword;
    @BindView(R.id.createPassConf) TextView mCreatePasswordConf;
    @BindView(R.id.createAccOk) Button mCreateAccOk;
    @BindView(R.id.accViewGroup) LinearLayout mAccViewGroup;
    @BindView(R.id.loginViewGroup) LinearLayout mLoginViewGroup;
    @BindView(R.id.loginTitle) TextView mLoginTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        Typeface leck = Typeface.createFromAsset(getAssets(),"fonts/leck.ttf");
        mLoginButt.setTypeface(leck);
        mCreateAccButt.setTypeface(leck);
        mLoginTitle.setTypeface(leck);

        mLoginButt.setOnClickListener(this);
        mCreateAccButt.setOnClickListener(this);
        mCreateAccOk.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();


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

        if (v == mCreateAccOk) {
            Log.v("HEY", "EJERJERJEWRWEEWRKEWRKEWRKWER");
            createNewUser();
        }
    }

    public void slideToBottom(View view){
        if (view.getVisibility()==View.GONE) {
            TranslateAnimation animate = new TranslateAnimation(0,0,-150,25);
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

    private void createNewUser() {
        final String name = mCreateName.getText().toString().trim();
        final String email = mCreateEmail.getText().toString().trim();
        final String pass = mCreatePassword.getText().toString().trim();
        final String passConf = mCreatePasswordConf.getText().toString().trim();

        boolean validEmail = checkEmail(email);
        boolean validName = checkName(name);
        boolean validPassword = checkPassword(pass, passConf);
        if (!validEmail || !validName || !validPassword) return;

        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d("HEY", "it worked");
                    Toast.makeText(LoginActivity.this, "New Account Created", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Sorry, New Account Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean checkEmail(String email) {
        boolean emailOK =
                (email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!emailOK) {
            mCreateEmail.setError("Please enter a valid email address");
            return false;
        }
        return emailOK;
    }

    private boolean checkName(String name) {
        if (name.trim().equals(" ")) {
            mCreateName.setError("Please enter your name");
            return false;
        }
        return true;
    }

    private boolean checkPassword(String password, String confirmPassword) {
        if (password.length() < 6) {
            mCreatePassword.setError("Please create a password containing at least 6 characters");
            return false;
        } else if (!password.equals(confirmPassword)) {
            mCreatePasswordConf.setError("Passwords do not match");
            return false;
        }
        return true;
    }


}
