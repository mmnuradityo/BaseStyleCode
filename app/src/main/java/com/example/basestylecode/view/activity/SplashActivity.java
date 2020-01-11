package com.example.basestylecode.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int splashInterval = 460;
        new Handler().postDelayed(() ->
                startActivity(new Intent(this, MainBaseActivity.class)
                ), splashInterval);
    }

}
