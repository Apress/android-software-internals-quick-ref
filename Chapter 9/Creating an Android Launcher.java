//Creating a launcher application

//First add the following attribute to the activities activity tag in the AndroidManifest.xml file:
/*
android:launchMode="singleTask"
*/

//Then add two categories to the intent filter of the same activity tag:
/*
<category android:name="android.intent.category.DEFAULT" />
<category android:name="android.intent.category.HOME" />
*/

//At this stage the application will function as a Launcher and will be selectable as a Home screen for the Android device’s settings. The below details several additional techniques that can be useful when creating a Launcher.

//Additional Functionality:

//Retrieving a list of applications
private List<ResolveInfo> getListOfApplications(Context context){
    Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
    mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
    List<ResolveInfo> pkgAppsList = context.getPackageManager().queryIntentActivities( mainIntent, 0);
    return pkgAppsList;
}

//Retrieving an application's icon
public static Drawable getActivityIcon(Context context, String packageName, String activityName) {
    PackageManager pm = context.getPackageManager();
    Intent intent = new Intent();
    intent.setComponent(new ComponentName(packageName, activityName));
    ResolveInfo resolveInfo = pm.resolveActivity(intent, 0);

    return resolveInfo.loadIcon(pm);
}

//Setting an image view. Add an ImageView object to your activity with the name imageView.
<ImageView
    android:id="@+id/imageView"
    android:layout_width="129dp"
    android:layout_height="129dp"
    android:foregroundGravity="center_vertical"
    app:srcCompat="@android:drawable/ic_dialog_alert"
    android:layout_gravity="center"
    />

//Create an on click listener for the ImageView.
ImageView chromeIcon = (ImageView) findViewById(R.id.imageView);
chromeIcon.setImageDrawable(getActivityIcon(getApplicationContext(),"com.android.chrome", "com.google.android.apps.chrome.Main"));

ImageView img = findViewById(R.id.imageView);
img.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
        startActivity(launchIntent);
    }
});

//Setting the wallpaper. Add the below to the styles.xml in the style tag under the name AppTheme.
<item name="android:windowShowWallpaper">true</item>
<item name="android:windowBackground">@android:color/transparent</item>
Hiding the system UI
private void hideSystemUI() {
    View decorView = getWindow().getDecorView();
    decorView.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_IMMERSIVE
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN);
