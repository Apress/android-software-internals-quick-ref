//Accessing files in the assets folder.
private String readFileFromAssets(String filename, String type){
    BufferedReader reader = null;

    StringBuilder stringBuilder = new StringBuilder();

    try {
        reader = new BufferedReader(
                new InputStreamReader(getAssets().open(filename), type)); //e.g. "utf-8"

        String mLine;

        while ((mLine = reader.readLine()) != null) {
            stringBuilder.append(mLine+"\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    return stringBuilder.toString();
}
