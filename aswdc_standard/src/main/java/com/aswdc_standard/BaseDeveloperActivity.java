package com.aswdc_standard;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.aswdc_standard.custom_interface.OnDbUpdateClick;

import java.util.Calendar;

public class BaseDeveloperActivity extends LibBaseActivity {
    TextView tvDeveloperName;
    TextView tvMentorName;
    ImageView ivAppIcon;
    TextView tvAppVersion;
    TextView tvCompanyRights;
    TextView tvDevelopedBy;
    TextView tvMentoredBy;
    TextView tvAswdcText;
    TextView tvDUText;
    WebView wvDetail;
    IconTextView dev_ic_mail;
    IconTextView dev_ic_phone;
    IconTextView dev_ic_web;
    IconTextView dev_ic_share;
    IconTextView dev_ic_app;
    IconTextView dev_ic_rate;
    IconTextView dev_ic_like;
    IconTextView dev_ic_update;
    IconTextView dev_db_update;
    OnDbUpdateClick onDbUpdateClick;
    LinearLayout llDbUpdate;
    LinearLayout llContainerTeam;
    LinearLayout llContact;
    LinearLayout llSocialMedia;
    LinearLayout llWebview;

    TextView tvHeaderOurTeam;
    TextView tvHeaderAswdc;
    TextView tvHeaderContactUs;

    String appName;
    String shareMessage;
    String packageName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_screen);
        setTitle("About Us");
        ivAppIcon = findViewById(R.id.ivAppIcon);
        tvAppVersion = findViewById(R.id.tvAppVersion);
        tvDevelopedBy = findViewById(R.id.tvDevelopedBy);
        tvMentoredBy = findViewById(R.id.tvMentoredBy);
        tvAswdcText = findViewById(R.id.tvAswdcText);
        tvDUText = findViewById(R.id.tvDUText);
        tvHeaderOurTeam = findViewById(R.id.tvHeaderOurTeam);
        tvHeaderAswdc = findViewById(R.id.tvHeaderAswdc);
        tvHeaderContactUs = findViewById(R.id.tvHeaderContactUs);
        llContainerTeam = findViewById(R.id.llContainerTeam);
        llContact = findViewById(R.id.llContact);
        llSocialMedia = findViewById(R.id.llSocialMedia);
        llWebview = findViewById(R.id.llWebview);

        dev_ic_mail = findViewById(R.id.dev_ic_mail);
        dev_ic_phone = findViewById(R.id.dev_ic_phone);
        dev_ic_web = findViewById(R.id.dev_ic_web);
        dev_ic_share = findViewById(R.id.dev_ic_share);
        dev_ic_app = findViewById(R.id.dev_ic_app);
        dev_ic_rate = findViewById(R.id.dev_ic_rate);
        dev_ic_like = findViewById(R.id.dev_ic_like);
        dev_ic_update = findViewById(R.id.dev_ic_update);
        dev_db_update = findViewById(R.id.dev_db_update);

        setPrimaryTextColor(dev_ic_mail);
        setPrimaryTextColor(dev_ic_phone);
        setPrimaryTextColor(dev_ic_web);
        setPrimaryTextColor(dev_ic_share);
        setPrimaryTextColor(dev_ic_app);
        setPrimaryTextColor(dev_ic_rate);
        setPrimaryTextColor(dev_ic_like);
        setPrimaryTextColor(dev_ic_update);
        setPrimaryTextColor(dev_db_update);

        setPrimaryTextColor(tvAppVersion);
        setPrimaryTextColor(tvMentoredBy);
        setPrimaryTextColor(tvDevelopedBy);
        setPrimaryTextColor(tvMentoredBy);
        setPrimaryTextColor(tvAswdcText);
        setPrimaryTextColor(tvDUText);
        setPrimaryTextColor(tvAppVersion);
        setPrimaryTextColor(tvAppVersion);
        tvDeveloperName = findViewById(R.id.tvDeveloperName);
        tvMentorName = findViewById(R.id.tvMentorName);
        wvDetail = findViewById(R.id.developer_wv_detail);
        tvCompanyRights = findViewById(R.id.tvCompanyRights);
        llDbUpdate = findViewById(R.id.check_database_update);
        if (savedInstanceState != null) {
            ivAppIcon.setImageResource(savedInstanceState.getInt(LibConstants.APP_ICON));
            appName = savedInstanceState.getString(LibConstants.APP_TITLE);
            tvAppVersion.setText(savedInstanceState.getString(LibConstants.APP_TITLE) + " (v" + savedInstanceState.getString(LibConstants.APP_VERSION) + ")");
            shareMessage = savedInstanceState.getString(LibConstants.APP_SHARE_MESSAGE);
            onDbUpdateClick = (OnDbUpdateClick) savedInstanceState.getSerializable(LibConstants.ON_DB_UPDATE_CLICK);
            tvDeveloperName.setText(savedInstanceState.getString(LibConstants.APP_DEVELOPER_NAME) + ",\nSchool Of Computer Science");
            tvMentorName.setText(savedInstanceState.getString(LibConstants.APP_MENTOR_NAME) + ",\nSchool Of Computer Science");
            packageName = savedInstanceState.getString(LibConstants.APP_PACKAGE_NAME);
        }
        setDeveloperDrawable();
        setWebviewBackground();
        llDbUpdate.setVisibility(onDbUpdateClick != null ? View.VISIBLE : View.GONE);
        tvCompanyRights.setText("\uf1f9 " + Calendar.getInstance().get(Calendar.YEAR) + "  Darshan University");
        wvDetail.loadDataWithBaseURL(null, "<html><body align=\"justify\" style=\"font-size:15px;color:#747474\">ASWDC is Application, Software and Website Development Center @ Darshan University run by Students and Staff of School Of Computer Science.<br><br> Sole purpose of ASWDC is to bridge gap between university curriculum &amp; industry demands. Students learn cutting edge technologies, develop real world application &amp; experiences professional environment @ ASWDC under guidance of industry experts &amp; faculty members.", "text/html", "utf-8", null);
    }

    void setDeveloperDrawable() {
        GradientDrawable gd = (GradientDrawable) ContextCompat.getDrawable(this, R.drawable.background_textview_developer);
        gd.setColor(ContextCompat.getColor(this, R.color.design_default_color_primary_dark));
        tvHeaderContactUs.setBackground(gd);

        GradientDrawable gd1 = (GradientDrawable) ContextCompat.getDrawable(this, R.drawable.background_textview_developer);
        gd1.setColor(ContextCompat.getColor(this, R.color.design_default_color_primary_dark));
        tvHeaderAswdc.setBackground(gd1);

        GradientDrawable gd2 = (GradientDrawable) ContextCompat.getDrawable(this, R.drawable.background_textview_developer);
        gd2.setColor(ContextCompat.getColor(this, R.color.design_default_color_primary_dark));
        tvHeaderOurTeam.setBackground(gd2);
    }

    void setWebviewBackground() {
        GradientDrawable gd = (GradientDrawable) ContextCompat.getDrawable(this, R.drawable.background_webview_developera);
        gd.setStroke(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 3 : 1, ContextCompat.getColor(this, R.color.design_default_color_primary_dark));
        llContainerTeam.setBackground(gd);

        GradientDrawable gd1 = (GradientDrawable) ContextCompat.getDrawable(this, R.drawable.background_webview_developera);
        gd1.setStroke(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 3 : 1, ContextCompat.getColor(this, R.color.design_default_color_primary_dark));
        llContact.setBackground(gd1);

        GradientDrawable gd2 = (GradientDrawable) ContextCompat.getDrawable(this, R.drawable.background_webview_developera);
        gd2.setStroke(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 3 : 1, ContextCompat.getColor(this, R.color.design_default_color_primary_dark));
        llSocialMedia.setBackground(gd2);

        GradientDrawable gd3 = (GradientDrawable) ContextCompat.getDrawable(this, R.drawable.background_webview_developera);
        gd3.setStroke(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ? 3 : 1, ContextCompat.getColor(this, R.color.design_default_color_primary_dark));
        llWebview.setBackground(gd3);
    }

    public void onDbUpdateClick(View view) {
        if (onDbUpdateClick != null) {
            onDbUpdateClick.onDbUpdateClick();
        }
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
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Admission+Mobile+Apps")));
        } catch (ActivityNotFoundException e) {
            Intent moreappsintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            startActivity(moreappsintent);
        }
    }

    public void onRateClick(View view) {
        try {
            Intent rateintent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
            startActivity(rateintent);
        } catch (ActivityNotFoundException e) {
            Intent moreappsintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            startActivity(moreappsintent);
        }
    }

    public void onFBClick(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/DarshanInstitute.Official")));
    }

    public void onPrivacyClick(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://darshan.ac.in/aswdc-privacy-policy-general")));
    }

    public void onUpdateClick(View view) {
        Log.d("packageName::::", "" + packageName);
        try {
            Intent updateintent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + packageName));
            startActivity(updateintent);
        } catch (ActivityNotFoundException e) {
            Intent moreappsintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + packageName));
            startActivity(moreappsintent);
        }
    }
}