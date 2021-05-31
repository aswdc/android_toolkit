package com.example.standarddemo;

import android.os.Bundle;

import com.aswdc_standard.BaseSplashActivity;
import com.aswdc_standard.LibConstants;

public class SplashScreenActivity extends BaseSplashActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(getSplashScreenDetail(BuildConfig.APPLICATION_ID));
    }
}