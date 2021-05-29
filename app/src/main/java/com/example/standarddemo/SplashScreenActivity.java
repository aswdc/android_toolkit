package com.example.standarddemo;

import android.os.Bundle;

import com.aswdc_standard.BaseSplashActivity;
import com.aswdc_standard.LibConstants;

public class SplashScreenActivity extends BaseSplashActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        savedInstanceState = new Bundle();
        savedInstanceState.putInt(LibConstants.APP_ICON, R.mipmap.ic_launcher_round);
        savedInstanceState.putInt(LibConstants.APP_TITLE, R.string.app_name);
        savedInstanceState.putString(LibConstants.APP_VERSION, BuildConfig.VERSION_NAME);
        super.onCreate(savedInstanceState);

    }
}