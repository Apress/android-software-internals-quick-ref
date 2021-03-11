//An external storage write runtime request can be run with the below code.
if (Build.VERSION.SDK_INT >= 23) {
    if (!isStoragePermissionGranted()){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1234567);
    }
}

//An example method that checks if the WRITE_EXTERNAL_STORAGE runtime permission is already set.
public  boolean isStoragePermissionGranted() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG,"Permission is granted");
            return true;
        } else {

            Log.v(TAG,"Permission is revoked");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            return false;
        }
    }
    else { //permission is automatically granted on sdk<23 upon installation
        Log.v(TAG,"Permission is granted");
        return true;
    }
}

//The activity callback that is executed when the permission changes.
@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
        Log.v(TAG,"Permission: "+permissions[0]+ " was "+grantResults[0]);
        //write file to external storage
    }
}
