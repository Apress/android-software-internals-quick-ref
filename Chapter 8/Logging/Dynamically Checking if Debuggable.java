//Example of dynamically checking if an application is in a debug state:
boolean isDebuggable =  ( 0 != ( getApplicationInfo().flags & ApplicationInfo.FLAG_DEBUGGABLE ) );
if (isDebuggable){
    Log.d(TAG,"This log will check programmatically if the app is debuggable.");
}
