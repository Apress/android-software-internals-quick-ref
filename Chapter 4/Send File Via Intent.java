//Sending a file to another activity. As of API level 24 sending files to other applications  requires a file provider so that a custom uri can be shared.
public void sendFileToAnoutherApplication(){
     File file =new File(getApplicationContext().getFilesDir(),"/text/test.txt");
     writeFileInInternalStorage(file, "Hello World");

     Intent intent = new Intent(Intent.ACTION_SEND);

     Uri contentUri = getUriForFile(getApplicationContext(), "com.example.intents.fileprovider", file);
     intent.setType("text/plain");

     intent.putExtra(Intent.EXTRA_STREAM,contentUri);

     startActivity(Intent.createChooser(intent , "File path"));
 }
