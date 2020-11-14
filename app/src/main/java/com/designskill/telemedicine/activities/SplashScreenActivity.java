package com.designskill.telemedicine.activities;

import android.content.Intent;
import android.os.Bundle;

import com.designskill.telemedicine.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SplashScreenActivity extends AppCompatActivity {

    Button signUpbutton, signInbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        init();


    }

    private void init() {

        signUpbutton = findViewById(R.id.signUpbutton);
        signUpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SplashScreenActivity.this, SignupActivity.class));
                finish();

            }
        });


        signInbutton = findViewById(R.id.signInbutton);
        signInbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SplashScreenActivity.this, SignInActivity.class));
                finish();
            }
        });
    }

}
