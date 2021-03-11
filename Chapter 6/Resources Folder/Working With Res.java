//Return a string (Strings should be stored in the strings.xml file) from the res folder:
getApplicationContext().getString(R.string.string_name)

//Return an image from the res folder. Bear in mind that Images are stored in the root of the Res drawable folder and that when accessing an image to not include the image extension.
ContextCompat.getDrawable(getApplicationContext(), R.drawable.image_name)
 
