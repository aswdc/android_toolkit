package com.example.standarddemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.aswdc_standard.BaseSplashActivity;

public class SplashScreenActivity extends BaseSplashActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(setSplashScreenDetail(BuildConfig.APPLICATION_ID, false, false));
        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashScreenActivity.this, DeveloperActivity.class));
            finish();
        }, 6000);
    }
}