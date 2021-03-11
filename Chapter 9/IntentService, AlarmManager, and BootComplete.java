//Below is a function that will set up an AlarmManager to repeat every x minutes as defined by the waitBeforeRepeatInMinutes parameter.
public void startPeriodicWork(long waitBeforeRepeatInMinutes){

  // Construct an intent that will execute the AlarmReceiver
  Intent intent = new Intent(context, AlarmReceiver.class);

  // Create a PendingIntent to be triggered when the alarm goes off
  final PendingIntent pIntent = PendingIntent.getBroadcast(context, AlarmReceiver.REQUEST_CODE,
          intent, PendingIntent.FLAG_UPDATE_CURRENT);

  // Setup periodic alarm every every half hour from this point onwards
  long firstMillis = System.currentTimeMillis(); // alarm is set right away
  AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

  // First parameter is the type: ELAPSED_REALTIME, ELAPSED_REALTIME_WAKEUP, RTC_WAKEUP
  // Interval can be INTERVAL_FIFTEEN_MINUTES, INTERVAL_HALF_HOUR, INTERVAL_HOUR, INTERVAL_DAY

  if (alarm != null) {
      alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis,
              waitBeforeRepeatInMinutes * 60 * 1000, pIntent);
  }

}

//Next create the AlarmManager BroadcastReceiver class. Set the process property in the Android manifest so that it will continue to stay alive if the app has closed . As part of this add the BroadcastReceiver to the AndroidManifest.xml file.
/*
<receiver android:name=".receivers.AlarmReceiver"
    android:process=":remote" />
*/

//Add the below to AlarmReceiver.java.
public class AlarmReceiver extends BroadcastReceiver {
    public static final int REQUEST_CODE = 12345;

    // Triggered by the Alarm periodically (starts the service to run task)
    @Override
    public void onReceive(Context context, Intent intent) {

        int tid = Process.myTid();
        Log.v("TaskScheduler", "Started Alarm Receiver with tid "+ tid);

        TaskManager taskManager = new TaskManager(context);
        taskManager.oneOffTask();
    }
}

//Next add the BroadcastReceiver for BootComplete. Add the below to the AndroidManifest.xml file.
/*
<receiver android:name=".receivers.BootReceiver">
    <intent-filter>
        <action android:name="android.intent.action.BOOT_COMPLETED" />
    </intent-filter>
</receiver>
*/

//Then create the BootReceiver.java class.
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int tid = Process.myTid();
        Log.v("TaskScheduler", "Started Boot Complete Receiver with tid "+ tid);

        TaskManager taskManager = new TaskManager(context);
        taskManager.startPeriodicWork(5);
    }
}

//Finally create the IntentService, for this make a file called ServiceManager.java.
public class ServiceManager extends IntentService {

    public ServiceManager() {
        super("ServiceTest"); //Used to name the worker thread, important only for debugging.
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        int tid = Process.myTid();
        Log.v("TaskScheduler", "Started Service with tid "+ tid);

        String val = intent.getStringExtra("foo");
        //todo Add the work to be performed here.
    }
}

//Add this service to the AndroidManifest.xml file.
/*
  <service android:name=".managers.ServiceManager"
    android:exported="false"/>
*/
