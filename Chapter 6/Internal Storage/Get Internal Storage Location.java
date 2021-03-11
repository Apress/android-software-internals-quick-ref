//From API level 24 and later the below can be used to retrieved the file path to the root of an application’s internal storage:
getApplicationContext().getDataDir();
//Before API level 24 the below can be used:
getApplicationContext().getFilesDir().getParent();
