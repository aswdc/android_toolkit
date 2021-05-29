package com.example.standarddemo;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.aswdc_standard.BaseDeveloperActivity;
import com.aswdc_standard.BaseSplashActivity;
import com.aswdc_standard.LibConstants;

public class DeveloperActivity extends BaseDeveloperActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        savedInstanceState = new Bundle();
        savedInstanceState.putInt(LibConstants.APP_ICON, R.mipmap.ic_launcher_round);
        savedInstanceState.putInt(LibConstants.APP_TITLE, R.string.app_name);
        savedInstanceState.putString(LibConstants.APP_VERSION, BuildConfig.VERSION_NAME);
        savedInstanceState.putString(LibConstants.APP_NAME, getString(R.string.app_name));
        savedInstanceState.putString(LibConstants.APP_SHARE_MESSAGE, getString(R.string.app_name));
        savedInstanceState.putString(LibConstants.APP_DEVELOPER_NAME, "");
        savedInstanceState.putString(LibConstants.APP_MENTOR_NAME, "");
        super.onCreate(savedInstanceState);
    }
}
