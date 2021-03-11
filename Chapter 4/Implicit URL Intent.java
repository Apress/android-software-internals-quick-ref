//Implicit URL intent
public void webIntent(){
    Uri webpage = Uri.parse("https://www.android.com");
    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
    startActivity(webIntent);
}
