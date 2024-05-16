package com.example.standarddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout layoutBackground;
    TextView tvAppVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        layoutBackground = findViewById(R.id.mainFrame);
        tvAppVersion = findViewById(R.id.tvAppVersion);
        layoutBackground.setAlpha((float) 0.8);
        PackageManager manager = this.getPackageManager();
        PackageInfo info = null;
        try {
             info = manager.getPackageInfo(this.getPackageName(), PackageManager.GET_ACTIVITIES);
        }catch (Exception e){

        }
        if (info==null){
            tvAppVersion.setVisibility(View.GONE);
        }else{
            tvAppVersion.setText("V" + info.versionName);
        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    /*Intent in = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(in);
                    finish();*/
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}