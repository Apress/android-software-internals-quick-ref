String filesLocation = getApplicationContext().getDataDir().getAbsolutePath();

try {
    Runtime.getRuntime().exec("touch "+filesLocation+"/test.txt");
} catch (IOException e) {
    e.printStackTrace();
}
