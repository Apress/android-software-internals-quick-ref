//Starting an internal activity with data:
public void sendIntentToActivityInApp(){
    Intent intent= new Intent(this, IntentReceiver.class);
    // Update class to be internal class (to the application) to receive the intent
    Bundle bundle= new Bundle();
    bundle.putString("key", "value");
    intent.putExtras(bundle);
    startActivity(intent);
}
