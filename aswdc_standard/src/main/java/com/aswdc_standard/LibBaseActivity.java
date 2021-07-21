package com.aswdc_standard;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.aswdc_standard.custom_interface.OnDbUpdateClick;
import com.google.android.material.bottomsheet.BottomSheetDialog;

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

    public int getAppPrimaryColor(String packageName) {
        try {
            final PackageManager pm = getPackageManager();
            final Resources res = pm.getResourcesForApplication(packageName);
            final int[] attrs = new int[]{
                    res.getIdentifier("colorPrimary", "attr", packageName),
                    android.R.attr.colorPrimary
            };
            final Resources.Theme theme = res.newTheme();
            final ComponentName cn = pm.getLaunchIntentForPackage(packageName).getComponent();
            theme.applyStyle(pm.getActivityInfo(cn, 0).theme, false);
            TypedArray a = theme.obtainStyledAttributes(attrs);
            final int colorPrimary = a.getColor(0, a.getColor(1, Color.WHITE));
            a.recycle();
            a = null;
            return colorPrimary;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void setPrimaryTextColor(TextView view) {
        view.setTextColor(ContextCompat.getColor(this, R.color.design_default_color_primary));
    }

    public void showBottomSheetDialog(String text) {
        BottomSheetDialog mBottomSheetDialog = new BottomSheetDialog(this);
        View sheetView = getLayoutInflater().inflate(R.layout.bottom_dialog_disclaimer, null);
        mBottomSheetDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mBottomSheetDialog.setContentView(sheetView);
        ((WebView) sheetView.findViewById(R.id.ans_web_ans)).loadData(text, "text/html", "utf-8");
        (sheetView.findViewById(R.id.btnClose)).setOnClickListener(view -> mBottomSheetDialog.cancel());
        mBottomSheetDialog.show();
    }

    public void showNetworkAlert(final boolean isFininsh) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Connection Problem\n" + "Check Your Internet Connection");
        dialog.setPositiveButton("OK", (dialog1, which) -> {
            if (isFininsh)
                finish();
        });
        dialog.show();
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

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    public Bundle setDeveloperScreenDetail(String packageName, String shareMessage, String developerName, String mentorName, OnDbUpdateClick onDbUpdateClick) {
        Bundle bundle = new Bundle();
        bundle.putInt(LibConstants.APP_ICON, getAppIcon(packageName));
        bundle.putString(LibConstants.APP_TITLE, getAppNameFromPkgName(packageName));
        bundle.putString(LibConstants.APP_VERSION, getVerionByPackageName(packageName));
        bundle.putString(LibConstants.APP_SHARE_MESSAGE, shareMessage);
        bundle.putString(LibConstants.APP_DEVELOPER_NAME, developerName);
        bundle.putString(LibConstants.APP_PACKAGE_NAME, packageName);
        bundle.putString(LibConstants.APP_MENTOR_NAME, mentorName);
        bundle.putSerializable(LibConstants.ON_DB_UPDATE_CLICK, onDbUpdateClick);
        return bundle;
    }

    public Bundle setSplashScreenDetail(String packageName, boolean isShowAppversion, boolean isShowAppName, int appIcon) {
        Bundle bundle = new Bundle();
        bundle.putInt(LibConstants.APP_ICON, appIcon == 0 ? getAppIcon(packageName) : appIcon);
        bundle.putString(LibConstants.APP_TITLE, getAppNameFromPkgName(packageName));
        bundle.putString(LibConstants.APP_VERSION, getVerionByPackageName(packageName));
        bundle.putBoolean(LibConstants.IS_APP_VERSION, isShowAppversion);
        bundle.putBoolean(LibConstants.IS_APP_NAME, isShowAppName);
        return bundle;
    }
}
