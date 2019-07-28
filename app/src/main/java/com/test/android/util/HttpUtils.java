package com.test.android.util;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HttpUtils {
    private static final String URL = "http:/10.0.2.2:8080/api-app/api/log";

    public static void sendLog(Context context, String message) {
        Map<String, String> params = new HashMap();
        params.put("message", message);
        params.put("tag", "test_tag");
        String androidId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        params.put("appId", androidId);

        JSONObject parameters = new JSONObject(params);

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST,
                URL,
                parameters,
                response -> Log.e("REST Response", response.toString()),
                error -> Log.e("REST Error", error.toString()));

        Volley.newRequestQueue(context).add(jsonRequest);
    }
}
