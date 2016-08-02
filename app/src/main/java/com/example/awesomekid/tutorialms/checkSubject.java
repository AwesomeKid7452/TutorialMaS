package com.example.awesomekid.tutorialms;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AwesomeKid on 31/07/16.
 */
public class checkSubject extends StringRequest {
    private static final String CHECK_REQUEST_URL = "http://tutorialmanasys.site88.net/checkSubject.php";
    private Map<String, String> params;

    public checkSubject(String subject_name, String level, Response.Listener<String> listener) {
        super(Request.Method.POST, CHECK_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("subject_name", subject_name);
        params.put("level", level);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}


