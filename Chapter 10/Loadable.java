public class Loadable {
    private final static String description = "This is a class that contains an assortment of access modifiers to test different types of reflection.";
    private Context context;
    private long uniqueId = 0;
    private long time = 0;
    private DeviceData deviceData = new DeviceData();

    public void setDeviceInfo() {
        deviceData.setDeviceInfo();
    }

    public long getTime() {
        return time;
    }

    private Loadable(Context context, long uniqueId) {
        this.context = context;
        this.uniqueId = uniqueId;
    }

    private void setTime(){
        this.time = System.currentTimeMillis();
    }

    private static String getDeviceName(){
        return android.os.Build.MODEL;
    }

    protected static Loadable construct(Context context){

        final int uniqueId = new Random().nextInt((1000) + 1);

        Loadable loadable = new Loadable(context, uniqueId);
        loadable.setDeviceInfo();
        return loadable;
    }
}
