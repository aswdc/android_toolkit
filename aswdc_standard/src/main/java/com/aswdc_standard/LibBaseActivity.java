package com.aswdc_standard;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class LibBaseActivity extends AppCompatActivity {

    public String getVerionByPackageName(String packageName) {
        try {
            PackageManager pm = getPackageManager();
            PackageInfo pInfo = pm.getPackageInfo(packageName, 0);
            return pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getAppNameFromPkgName(String Packagename) {
        try {
            PackageManager packageManager = getPackageManager();
            ApplicationInfo info = packageManager.getApplicationInfo(Packagename, PackageManager.GET_META_DATA);
            String appName = (String) packageManager.getApplicationLabel(info);
            return appName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public int getAppIcon(String packageName) {
        try {
            return getPackageManager().getApplicationInfo(packageName, 1).icon;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public Bundle getSplashScreenDetail(String packageName) {
        Bundle bundle = new Bundle();
        bundle.putInt(LibConstants.APP_ICON, getAppIcon(packageName));
        bundle.putString(LibConstants.APP_TITLE, getAppNameFromPkgName(packageName));
        bundle.putString(LibConstants.APP_VERSION, getVerionByPackageName(packageName));
        return bundle;
    }
}
