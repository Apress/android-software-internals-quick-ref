//An example of a runtime permission request:
if (Build.VERSION.SDK_INT >= 23) {
    // Runtime permission will not be shown unless the correct manifest permission is already set.
    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1234);
}
