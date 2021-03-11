//Retrieve the current class loader.
ClassLoader loader = getApplicationContext().getClassLoader();

//As of API level 26 (Android O) it is possible to read a dex file directly from memory. To do this read a ByteBuffer of a file and use the class InMemoryDexClassLoader. The below is a helper function for reading a file to a byte array.
private static byte[] readFileToByteArray(File file){
    FileInputStream fis = null;

    byte[] bArray = new byte[(int) file.length()];
    try{
        fis = new FileInputStream(file);
        fis.read(bArray);
        fis.close();

    }catch(IOException ioExp){
        ioExp.printStackTrace();
    }
    return bArray;
}

//In memory dex class loading
dexLoader = new InMemoryDexClassLoader(ByteBuffer.wrap(readFileToByteArray(filePath)), loader);

//The other option is to load the dex file directly from the file. The DexClassLoader class takes the dexPath (file path) of the .dex file, the optimizedDirectory - where .odex (optimized dex files) are stored prior to Android API level 26, the librarySearchPath - a string list (delimited by File.pathSeparator;) stating  directories containing native libraries, and parent - the parent ClassLoader.
dexLoader = new DexClassLoader(filePath, dexCacheDirectory.getAbsolutePath(), null, loader);

//After creating a dex class loader choose the class to load, as a string.
loadedClass = dexLoader.loadClass("me.jamesstevenson.dexloadable.MainActivity"); //alter path for your use case

//At this stage the uninitialised class can be used as normal, as described in the reflection section. The below shows how to safely initialise this class.
initialisedClass = loadedClass != null ? loadedClass.newInstance() : null;

//After initialising this class a specific method can be called, as a string, and it’s response can be returned as done previously with standard reflection. 
method = loadedClass != null ? loadedClass.getMethod("loadMeAndIllTakeContext", Context.class) : null;
Object methodResponse = method != null ? method.invoke(initialisedClass, getApplicationContext()) : null;
