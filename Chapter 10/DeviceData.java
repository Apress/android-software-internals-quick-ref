public class DeviceData {

    String version = ""; // OS version
    String sdkLevel = ""; // API Level
    String device = "";  // Device
    String model = "";   // Model
    String product = ""; // Product

    public void setDeviceInfo(){
        version = System.getProperty("os.version");
        sdkLevel = android.os.Build.VERSION.SDK;
        device = android.os.Build.DEVICE;
        model = android.os.Build.MODEL;
        product = android.os.Build.PRODUCT;
    }


    @Override
    public String toString() {
        return "DeviceData{" +
                "version='" + version + '\'' +
                ", sdkLevel='" + sdkLevel + '\'' +
                ", device='" + device + '\'' +
                ", model='" + model + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
