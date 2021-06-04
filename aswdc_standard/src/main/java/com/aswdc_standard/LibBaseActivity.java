package com.aswdc_standard;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

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

    public Bundle setDeveloperScreenDetail(String packageName, String shareMessage, String developerName, String mentorName) {
        Bundle bundle = new Bundle();
        bundle.putInt(LibConstants.APP_ICON, getAppIcon(packageName));
        bundle.putString(LibConstants.APP_TITLE, getAppNameFromPkgName(packageName));
        bundle.putString(LibConstants.APP_VERSION, getVerionByPackageName(packageName));
        bundle.putString(LibConstants.APP_SHARE_MESSAGE, shareMessage);
        bundle.putString(LibConstants.APP_DEVELOPER_NAME, developerName);
        bundle.putString(LibConstants.APP_MENTOR_NAME, mentorName);
        return bundle;
    }

    public Bundle setSplashScreenDetail(String packageName, boolean isShowAppversion, boolean isShowAppName) {
        Bundle bundle = new Bundle();
        bundle.putInt(LibConstants.APP_ICON, getAppIcon(packageName));
        bundle.putString(LibConstants.APP_TITLE, getAppNameFromPkgName(packageName));
        bundle.putString(LibConstants.APP_VERSION, getVerionByPackageName(packageName));
        bundle.putBoolean(LibConstants.IS_APP_VERSION,isShowAppversion);
        bundle.putBoolean(LibConstants.IS_APP_NAME,isShowAppName);
        return bundle;
    }
}
