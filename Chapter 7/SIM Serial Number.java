//Retrieving the SIM serial number:
TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
Log.v("SIM Serial Number", telephonyManager.getSimSerialNumber());
