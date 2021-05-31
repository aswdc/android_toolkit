package com.example.standarddemo;

import android.os.Bundle;

import com.aswdc_standard.BaseSplashActivity;

public class SplashScreenActivity extends BaseSplashActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(setSplashScreenDetail(BuildConfig.APPLICATION_ID));
    }
}