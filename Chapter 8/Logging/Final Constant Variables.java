//DEBUG value in BuildConfig file:
public static final boolean DEBUG = Boolean.parseBoolean("true");

//Implementing the DEBUG constant:
if (BuildConfig.DEBUG){
    Log.d(TAG,"This is a log that won't be compiled in a release build.");
}

/*When building for release, and set to false, the Java compiler will see that it is impossible for the final variable to be true and so doesn't compile the code inside of the if statement. This both means that the log won't be displayed in Logcat but it also means that the log string won't exist in the application’s source code as with a normal log message.
A similar affect to using BuildConfig.DEBUG can also be achieved if not using Gradle. This can be done using a final string and setting it to true when debugging and false for the release build.*/

//Setting a custom DEBUG constant:
final boolean SHOULD_LOG = false;
if (SHOULD_LOG){
   Log.d(TAG," A log that should never happen...");
}
