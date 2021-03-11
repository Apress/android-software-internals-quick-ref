//After this a file (inside of the specified directory) can be sent via an intent as normal. 
File file =new File(getApplicationContext().getFilesDir(),"/myText/test.txt");
writeFileInInternalStorage(file, "Hello World"); // This function is referenced in the Text Files section.

Intent intent = new Intent(Intent.ACTION_SEND);

Uri contentUri = getUriForFile(getApplicationContext(), "com.example.storage.fileprovider", file); //replace with package name
intent.setType("text/plain");
intent.putExtra(Intent.EXTRA_STREAM,contentUri);

startActivity(Intent.createChooser(intent , "Sharing Text File"));
