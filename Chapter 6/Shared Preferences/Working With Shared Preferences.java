//Adding a key-value pair
SharedPreferences sharedPref
        = getApplicationContext().getSharedPreferences("MySharedPref",
        MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPref.edit();
editor.putString("key", "value");
editor.apply();

//When reading from a shared preference you must provide a default value of the type being retrieved. This is returned if the provided key does not exist.
SharedPreferences sharedPref
        = getApplicationContext().getSharedPreferences("MySharedPref",
        MODE_PRIVATE);
String value = sharedPref.getString("key", "default value");

//Deleting a shared preference is similar to editing one, however, instead of using a .put method the .remove() method is used instead.
SharedPreferences sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPref.edit();
editor.remove("key");
editor.apply();
