package com.example.awesomekid.tutorialms;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AwesomeKid on 26/07/16.
 */
public class removeUserDB extends StringRequest {
    private static final String REMOVE_REQUEST_URL = "http://tutorialmanasys.site88.net/removeUser.php";
    private Map<String, String> params;

    public removeUserDB(String username, String title, Response.Listener<String> listener) {
        super(Request.Method.POST, REMOVE_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("title", title);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
