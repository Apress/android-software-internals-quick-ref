//Code such as the below should be used to identify if a background or foreground service should be used.
Intent intent = new Intent(context, ServiceManager.class); //replace with an appropriate intent
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    context.startForegroundService(intent);
}else{
    context.startService(intent);
}

//The below shows an example of setting up a notification channel:
public static void createNotificationChannel(Context context) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
        channel.setDescription(CHANNEL_DESC);

        NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
        }
    }
}

//Sending a notification:
Intent notificationIntent = new Intent(this, MainActivity.class);
PendingIntent pendingIntent = PendingIntent.getActivity(this,
        0, notificationIntent, 0);

Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
        .setContentTitle("Notification Title")
        .setContentText("Notification Text")
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentIntent(pendingIntent)
        .build();

startForeground(1, notification);
}

//As of Android 9 (API level 28) in addition to adding your Service to the Android manifest as below you will also need to add the FOREGROUND_SERVICE permission.
/*
<service android:name=".managers.ForegroundServiceManager"
    android:exported="false"/>
<uses-permission android:name="android.permission.FOREGROUND_SERVICE" />
*/
