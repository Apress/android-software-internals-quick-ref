//Certificate pinning example:
String hostname =  "google.com";

CertificatePinner certPinner = new CertificatePinner.Builder()
        .add(
                hostname,
                "sha256/MeCugOOsbHh2GNsYG8FO7wO7E4rjtmR7o0LM4iXHJlM="
        )
        .build();

OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .certificatePinner(certPinner)
        .build();

HttpUrl.Builder urlBuilder = HttpUrl.parse("https://"+hostname).newBuilder();
String url = urlBuilder.build().toString();

MediaType JSON = MediaType.parse("application/json; charset=utf-8");
RequestBody body = RequestBody.create(JSON, "{\"test\":\"testvalue\"}");

Request request = new Request.Builder()
        .url(url)
        .post(body)
        .build();

Log.v(TAG,request.toString());


Response response = null;
try {
    response = okHttpClient.newCall(request).execute();
    ResponseBody jsonData = response.body();
    Log.v(TAG, jsonData.toString());

} catch (IOException e) {
    e.printStackTrace();
}

return Result.success();
