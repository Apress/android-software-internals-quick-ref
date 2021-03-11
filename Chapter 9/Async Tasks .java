//Calling an AsyncTasks:
AsyncTask<String, Void, Void> task = new myAsyncTask(getApplicationContext()).execute("example string");

//Cancelling an AsyncTask:
task.cancel(true);

//Creating an AsyncTask class (make as a private or package-private subclass of your activity class):
class myAsyncTask extends AsyncTask<String, Void, Void> {
    private Context mContext;

    public myAsyncTask(Context context) {
        this.mContext = context;
    }

    @Override
    protected Void doInBackground(final String... strings) {
        final Context context = this.mContext;

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (String text:strings) {

                    Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return null;
    }
}
