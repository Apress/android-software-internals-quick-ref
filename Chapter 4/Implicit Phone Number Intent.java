//Implicit phone number intent
public void phoneNumberIntent(){
    Uri number = Uri.parse("tel:5551234");
    Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
    startActivity(callIntent);
}
