package com.example.standarddemo;

import android.os.Bundle;
import android.os.Parcel;

import androidx.annotation.Nullable;

import com.aswdc_standard.BaseDeveloperActivity;
import com.aswdc_standard.LibConstants;
import com.aswdc_standard.custom_interface.OnDbUpdateClick;

public class DeveloperActivity extends BaseDeveloperActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(setDeveloperScreenDetail(getPackageName(), "Share App",
                "Prof. Mehul Bhundiya", "Prof. Mayur Padia", null));
    }
}
