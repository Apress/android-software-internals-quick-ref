//Starting the thread:
public void startThread(){
    Thread thread = new ThreadManager();
    thread.start();
}

//Make a java class called ThreadManager.java.
public class ThreadManager extends Thread{
    public ThreadManager() {
        super();
    }

    @Override
    public void run() {
        long tid = getId();

        // Todo do work here.
        Log.v("TaskScheduler", "Starting a new thread "+ tid);

        while (true){
            Log.v("TaskScheduler", "In a thread: " + tid);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
