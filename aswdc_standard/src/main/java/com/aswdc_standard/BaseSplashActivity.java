package com.aswdc_standard;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

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
        ivIcon = findViewById(R.id.ivAppIcon);
        tvTitle = findViewById(R.id.tvTitle);
        tvAppVersion = findViewById(R.id.tvAppVersion);
        if (savedInstanceState != null) {
            ivIcon.setImageResource(savedInstanceState.getInt(LibConstants.APP_ICON));
            tvTitle.setText(savedInstanceState.getString(LibConstants.APP_TITLE));
            tvAppVersion.setText("V" + savedInstanceState.getString(LibConstants.APP_VERSION));
        }
    }
}