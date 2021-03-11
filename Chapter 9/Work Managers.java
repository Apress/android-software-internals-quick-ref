//Add the below dependencies to the gradle.build file when using work managers.
/*
def work_version = "2.3.3"

  // (Java only)
  implementation "androidx.work:work-runtime:$work_version"

  // Kotlin + coroutines
  implementation "androidx.work:work-runtime-ktx:$work_version"
*/

//The below code tasks and starts a work manager.
PeriodicWorkRequest work = new PeriodicWorkRequest.Builder(
        com.example.taskscheduler.managers.WorkManager.class, 15, TimeUnit.MINUTES)
        .build(); //update path to match your created WorkManager.java class

WorkManager.getInstance().cancelAllWork();
WorkManager.getInstance().enqueue(work);

//Finally create a class called WorkManager.java.
public class WorkManager extends Worker {

    Context context;

    public WorkManager(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

        this.context = context;
    }

    @Override
    public Result doWork() {
        int tid = Process.myTid();
        Log.v("TaskScheduler", "Worker started with tid "+ tid);
        // Todo run your work here.
        return Result.success();
    }
}
