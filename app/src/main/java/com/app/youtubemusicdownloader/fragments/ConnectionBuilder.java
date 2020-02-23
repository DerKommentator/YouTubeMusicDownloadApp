package com.app.youtubemusicdownloader.fragments;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import java.util.concurrent.TimeUnit;

public class ConnectionBuilder {

    OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    void post(String url, String json, Callback callback) {
        client.setConnectTimeout(80, TimeUnit.SECONDS); // connect timeout
        client.setReadTimeout(80, TimeUnit.SECONDS);    // socket timeout
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .header("Connection", "close")
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
