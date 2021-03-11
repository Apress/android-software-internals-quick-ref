//Get global external storage (API level 1 to 28)
Environment.getExternalStorageDirectory();
//Get Application scoped (sandboxed) external storage (API level 29+)
getApplicationContext().getExternalFilesDir(null);
