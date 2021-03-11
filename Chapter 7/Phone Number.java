//Retrieving the phone number:
TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
Log.v("Phone Number", telephonyManager.getLine1Number());
