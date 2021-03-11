//The advertising ID can be used by adding the following library path to the build.gradle file's dependencies tag.
//implementation 'com.google.android.gms:play-services-ads:7.0.0'

//Retrieving the advertising ID (this cannot be done on the main thread - this example uses an AsyncTask, see CHAPTER 9 for more information).
void getAdvertisingID(final Context context){


    AsyncTask.execute(new Runnable() {
        @Override
        public void run() {
            Info adInfo = null;
            try {
                adInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesRepairableException e) {
                e.printStackTrace();
            }
            String adId = adInfo != null ? adInfo.getId() : null;

            Log.v("Advertising ID",adId);

        }
    });
}
