//Pre and including Android N (25) access:
TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
Log.v("Device ID", telephonyManager.getDeviceId());

//Post (and including) Android O (26):
TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
Log.v("IMEI", telephonyManager.getImei());
Log.v("MEID", telephonyManager.getMeid());
 
