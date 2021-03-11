//To make a File object that operates on a specific file use the below code where filename is a String object representing the path to the file.
String filename = "myFile.txt";
File file = new File(getApplicationContext().getFilesDir(), filename);

//Writing a file:
public void writeFileInInternalStorage(File fileToWrite, String fileBody){

    // If file doesn't exist attempt to make full directory path
    if(!fileToWrite.exists()){
        fileToWrite.getParentFile().mkdir();
    }

    // Write to file
    try{
        FileWriter writer = new FileWriter(fileToWrite);
        writer.append(fileBody);
        writer.flush();
        writer.close();

    }catch (Exception e){
        e.printStackTrace();

    }
}

//Reading a file:
private String readFromFile(File file) {

    String ret = "";

    try {
        FileInputStream inputStream = new FileInputStream(file);

        if ( inputStream != null ) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ( (receiveString = bufferedReader.readLine()) != null ) {
                stringBuilder.append("\n").append(receiveString);
            }

            inputStream.close();
            ret = stringBuilder.toString();
        }
    }
    catch (FileNotFoundException e) {
        Log.e("TAG", "File not found: " + e.toString());
    } catch (IOException e) {
        Log.e("TAG", "Can not read file: " + e.toString());
    }

    return ret;
}

//Deleting a file:
private void deleteStorageFile(File file){
    file.delete();
}
