//Add the below. If not wanting a periodic worker then remove the setPeriodic and setPersisted tags.
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public void startJobScheduler(){
    ComponentName serviceComponent = new ComponentName(context, JobSchedulerManager.class);
    JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);
    //builder.setMinimumLatency(1 * 1000); // wait at least /Can't call setMinimumLatency() on a periodic job/
    //builder.setOverrideDeadline(3 * 1000); // maximum delay //Can't call setOverrideDeadline() on a periodic job.
    builder.setPeriodic(1000); //runs over time
    builder.setPersisted(true); // persists over reboot
    //builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED); // require unmetered network
    //builder.setRequiresDeviceIdle(true); // device should be idle
    //builder.setRequiresCharging(false); // we don't care if the device is charging or not
    JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);

    if (jobScheduler != null) {
        jobScheduler.schedule(builder.build());
    }
}

//Then make a class called JobSchedulerManager.java.
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerManager extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        int tid = Process.myTid();
        Log.v("TaskScheduler", "Started Job Scheduler with tid "+ tid);

        //todo perform work here

        // returning false means the work has been done, return true if the job is being run asynchronously
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}

//Add the below class to the AndroidManifest.xml file.
/*
<service android:name=".managers.JobSchedulerManager"
    android:permission="android.permission.BIND_JOB_SERVICE"/>
*/
