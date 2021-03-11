//Below is an example of an AES-256 encryption approach in Java.
try {
    Cipher cipher = null;
    cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

    KeyGenerator keygen = null;
    keygen = KeyGenerator.getInstance("AES");

    keygen.init(256);
    SecretKey key = keygen.generateKey();

    String plainTextString = "I am a plain text";
    String cipherTextAsString = "N/A";
    String newPlainTextAsString = "N/A";
    byte[] plainText = plainTextString.getBytes();

    cipher.init(Cipher.ENCRYPT_MODE, key);

    byte[] cipherText = new byte[0];

    cipherText = cipher.doFinal(plainText);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        cipherTextAsString = new String(cipherText, StandardCharsets.UTF_8);
    }

    IvParameterSpec iv = new IvParameterSpec(cipher.getIV());
    cipher.init(Cipher.DECRYPT_MODE, key, iv);

    byte[] newPlainText = cipher.doFinal(cipherText);
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        newPlainTextAsString = new String(newPlainText, StandardCharsets.UTF_8);
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Log.v(getApplicationContext().getPackageName(), "The plaintext '" + plainTextString + "' encrypted is " + Base64.getEncoder().encodeToString(cipherText) + " and decrypted is '" + newPlainTextAsString);
    }

}catch (NoSuchAlgorithmException e) {
    e.printStackTrace();
} catch (InvalidKeyException e) {
    e.printStackTrace();
} catch (InvalidAlgorithmParameterException e) {
    e.printStackTrace();
} catch (NoSuchPaddingException e) {
    e.printStackTrace();
} catch (BadPaddingException e) {
    e.printStackTrace();
} catch (IllegalBlockSizeException e) {
    e.printStackTrace();
}
