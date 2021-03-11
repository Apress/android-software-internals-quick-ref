//Enabling a component
PackageManager packageManager = getApplicationContext().getPackageManager();
ComponentName componentName = new ComponentName(getApplicationContext(), SecondaryActivity.class);
packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED,PackageManager.DONT_KILL_APP);

//Returning the state of a component
PackageManager packageManager = getApplicationContext().getPackageManager();
ComponentName componentName = new ComponentName(getApplicationContext(), SecondaryActivity.class);
int componentState = packageManager.getComponentEnabledSetting(componentName);

//Disabling a component
PackageManager packageManager = getApplicationContext().getPackageManager();
ComponentName componentName = new ComponentName(getApplicationContext(), SecondaryActivity.class);
packageManager.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED,PackageManager.DONT_KILL_APP);
