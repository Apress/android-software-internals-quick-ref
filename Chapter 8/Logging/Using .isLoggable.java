//Example of Log.isLoggable:
if (Log.isLoggable(TAG,Log.DEBUG)){
    Log.d(TAG,"A log using is loggable");
}
//This log level can be set via the shell using:
//setprop log.tag.<log_tag> <log_level>
