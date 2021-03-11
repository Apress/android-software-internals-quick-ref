//Starting a specific activity of an external application:
public void sendIntentToAnotherActivity(){
    Intent intent = new Intent();
    intent.setClassName("com.android.chrome", "com.google.android.apps.chrome.Main");
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;

    startActivity(intent);
}
