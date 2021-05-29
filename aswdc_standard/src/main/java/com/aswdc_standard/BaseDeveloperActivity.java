package com.aswdc_standard;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BaseDeveloperActivity extends LibBaseActivity {
    TextView tvDeveloperName;
    TextView tvMentorName;
    ImageView ivAppIcon;
    TextView tvAppVersion;
    TextView tvCompanyRights;
    WebView wvDetail;

    String appName;
    String shareMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_screen);
        setTitle("About Us");
        ivAppIcon = findViewById(R.id.ivAppIcon);
        tvAppVersion = findViewById(R.id.tvAppVersion);
        tvDeveloperName = findViewById(R.id.tvDeveloperName);
        tvMentorName = findViewById(R.id.tvMentorName);
        wvDetail = findViewById(R.id.developer_wv_detail);
        tvCompanyRights = findViewById(R.id.tvCompanyRights);

        if (savedInstanceState != null) {
            ivAppIcon.setImageResource(savedInstanceState.getInt(LibConstants.APP_ICON));
            tvAppVersion.setText(savedInstanceState.getInt(LibConstants.APP_TITLE));
            appName = savedInstanceState.getString(LibConstants.APP_NAME);
            tvAppVersion.setText(savedInstanceState.getString(LibConstants.APP_NAME) + " V(" + savedInstanceState.getString(LibConstants.APP_VERSION) + ")");
            shareMessage = savedInstanceState.getString(LibConstants.APP_SHARE_MESSAGE);
            tvDeveloperName.setText(savedInstanceState.getString(LibConstants.APP_DEVELOPER_NAME));
            tvMentorName.setText(savedInstanceState.getString(LibConstants.APP_MENTOR_NAME));
        }
        tvCompanyRights.setText("\uf1f9 " + Calendar.getInstance().get(Calendar.YEAR) + "  Darshan Institute of Engineering &amp; Technology");
        wvDetail.loadDataWithBaseURL(null, "<html><body align=\"justify\" style=\"font-size:15px;color:#747474\">ASWDC is Application, Software and Website Development Center @ Darshan Engineering College run by Students and Staff of Computer Engineering Department.<br><br> Sole purpose of ASWDC is to bridge gap between university curriculum &amp; industry demands. Students learn cutting edge technologies, develop real world application &amp; experiences professional environment @ ASWDC under guidance of industry experts &amp; faculty members", "text/html", "utf-8", null);
    }

    public void onEmailClick(View view) {
        Intent emailintent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "aswdc@darshan.ac.in", null));
        emailintent.putExtra(Intent.EXTRA_SUBJECT, "Contact from " + appName);
        startActivity(Intent.createChooser(emailintent, "Send Email to ASWDC"));
    }

    public void onLlCall(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+91-9727747317"));
        startActivity(intent);
    }

    public void onWebSiteClick(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.darshan.ac.in")));
    }

    public void onDuClick(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.darshan.ac.in")));
    }

    public void onAswdcClick(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.aswdc.in")));

    }

    public void onShareClick(View view) {
        Intent share = new Intent();
        share.setAction(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, shareMessage);
        startActivity(share);

    }

    public void onMoreAppsClick(View view) {
        try {
            Intent moreappsintent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:Darshan+Institute+of+Engineering+%26+Technology"));
            startActivity(moreappsintent);
        } catch (ActivityNotFoundException e) {
            Intent moreappsintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
            startActivity(moreappsintent);
        }
    }

    public void onRateClick(View view) {
        try {
            Intent rateintent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
            startActivity(rateintent);
        } catch (ActivityNotFoundException e) {
            Intent moreappsintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
            startActivity(moreappsintent);
        }

    }

    public void onFBClick(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/DarshanInstitute.Official")));

    }

    public void onPrivacyClick(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.darshan.ac.in/DIET/ASWDC-Mobile-Apps/Privacy-Policy-General")));

    }

    public void onUpdateClick(View view) {
        try {
            Intent updateintent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getPackageName()));
            startActivity(updateintent);
        } catch (ActivityNotFoundException e) {
            Intent moreappsintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
            startActivity(moreappsintent);
        }
    }
}