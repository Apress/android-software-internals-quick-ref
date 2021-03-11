//Starting an external application:
public void startActivityViaIntent(){
    Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
    startActivity(launchIntent);
}
