<b>Android Skeleton App</b>

This directory contains the full implementation of a basic application for the Android platform, demonstrating the basic facilities that applications will use.  You can run the application either directly from the "test"
list in the app launcher (it is named Skeleton App) or by selecting it from the top list in the Sample Code app.

The files contained here:

In your app_level project build.gradle file, add the following line in dependencies section
    implementation 'com.github.aswdc:android_toolkit:+'


For the project_level build.gradle file, add the following lines in the repositories section
    maven { url 'https://jitpack.io' }


AndroidManifest.xml

Contains entries for Splash Activity (.SplashScreenActivity) and Developer Activity (.DeveloperActivity).

standarddemo/*

Under this directory is the Java source for your application. It contains BaseActivity.java, DeveloperActivity.java, MainActivity.java, SplashScreenActivity.java. The developer will use the developer and splash activity from the skeleton provided.


/<Your Project Folder>/app/src/main/java/com/aswdc_yourprojectname/DeveloperActivity.java

Extend the class with extends BaseDeveloperActivity

Replace super.OnCreate line in your file with the given line below: super.onCreate(setDeveloperScreenDetail(getPackageName(), "Your app share message","Your Name","Your Project Guide Name"));

/<Your Project Folder>/app/src/main/java/com/aswdc_yourprojectname/SplashActivity.java

Extend the class with extends BaseDeveloperActivity

Replace super.OnCreate line in your file with the given lines below: 

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the MainActivity. */
                Intent mainIntent = new Intent(SplashScreen.this, <YourActivityYouWanttoOpen>.class);
                startActivity(mainIntent);
                finish();
            }
        }, 6000);


