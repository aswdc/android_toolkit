package com.aswdc_standard;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

public class BaseSplashActivity extends LibBaseActivity {

    ImageView ivIcon;
    TextView tvTitle;
    TextView tvAppVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        (findViewById(R.id.mainFrame)).setBackgroundColor(ContextCompat.getColor(this, R.color.design_default_color_primary));
        ivIcon = findViewById(R.id.ivAppIcon);
        tvTitle = findViewById(R.id.tvTitle);
        tvAppVersion = findViewById(R.id.tvAppVersion);
        if (savedInstanceState != null) {
            ivIcon.setImageResource(savedInstanceState.getInt(LibConstants.APP_ICON));
            tvTitle.setText(savedInstanceState.getString(LibConstants.APP_TITLE));
            tvAppVersion.setText("v" + savedInstanceState.getString(LibConstants.APP_VERSION));
            tvAppVersion.setVisibility(savedInstanceState.getBoolean(LibConstants.IS_APP_VERSION) ? View.VISIBLE : View.GONE);
            tvTitle.setVisibility(savedInstanceState.getBoolean(LibConstants.IS_APP_NAME) ? View.VISIBLE : View.GONE);
        }
    }
}