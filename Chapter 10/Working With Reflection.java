//Initialising a class:
try {
    Object initialisedDeviceData= DeviceData.class.newInstance();
    initialisedDeviceData.getClass().getDeclaredMethod("setDeviceInfo").invoke(initialisedDeviceData);
    String model = (String) initialisedDeviceData.getClass().getDeclaredField("model").get(initialisedDeviceData);
    Log.v(TAG, model);

} catch (IllegalAccessException e) {
    e.printStackTrace();
} catch (InstantiationException e) {
    e.printStackTrace();
} catch (NoSuchMethodException e) {
    e.printStackTrace();
} catch (InvocationTargetException e) {
    e.printStackTrace();
} catch (NoSuchFieldException e) {
    e.printStackTrace();
}

//getMethods() example:
for (Method method : Loadable.class.getMethods()){
     Log.v(TAG, method.getName());
 }

//getDeclaredMethods() example:
for (Method method : Loadable.class.getDeclaredMethods()){
     method.setAccessible(true);
     Log.v(TAG, method.getName());
 }

//The below is an example of constructing a class with a private constructor:
try {
    Constructor<?> constructor = Loadable.class.getDeclaredConstructor(Context.class, long.class);
    constructor.setAccessible(true);
    Object instance = constructor.newInstance(getApplicationContext(), (Object) 12); // constructor takes a context and an id.
    Field uniqueIdField = instance.getClass().getDeclaredField("uniqueId");
    uniqueIdField.setAccessible(true);
    long uniqueId = (long) uniqueIdField.get(instance);
    Log.v(TAG, ""+uniqueId);

} catch (InstantiationException e) {
    e.printStackTrace();
} catch (InvocationTargetException e) {
    e.printStackTrace();
} catch (NoSuchMethodException e) {
    e.printStackTrace();
} catch (IllegalAccessException e) {
    e.printStackTrace();
} catch (NoSuchFieldException e) {
    e.printStackTrace();
}

//Instance class example:
try {
    // The loadable class has a static method that can be used to construct it in this example, however, if the constructor isn't public,
    // this can also be done with the private constructor example.
    // and can be done as in the public class example.
    Object instance = Loadable.class.getDeclaredMethod("construct", Context.class)
            .invoke(Loadable.class, getApplicationContext());

    // Retrieve the field device data which is the class we're looking to get the data of.
    Field devicdDataField = instance.getClass().getDeclaredField("deviceData");
    devicdDataField.setAccessible(true);
    Object initialisedDeviceData = devicdDataField.get(instance);

    // After accessing the value from the field we're looking to access the filds of we can use the same type of reflection again after getting it's class.
    Field modelField = initialisedDeviceData.getClass().getDeclaredField("device");
    modelField.setAccessible(true);
    String model = (String) modelField.get(initialisedDeviceData);

    Log.v(TAG,model);

} catch (IllegalAccessException e) {
    e.printStackTrace();
} catch (InvocationTargetException e) {
    e.printStackTrace();
} catch (NoSuchMethodException e) {
    e.printStackTrace();
} catch (NoSuchFieldException e) {
    e.printStackTrace();
}
