//Receiving an Intent bundle in an activity:
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (getIntent().hasExtra("key")) {
      String value = getIntent().getExtras().getString("key");
      Log.v(this.getClass().getSimpleName(), value);
    }
}
