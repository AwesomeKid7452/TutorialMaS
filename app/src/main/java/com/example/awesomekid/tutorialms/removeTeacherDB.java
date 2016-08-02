package com.example.awesomekid.tutorialms;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AwesomeKid on 26/07/16.
 */
public class removeTeacherDB extends StringRequest {
    private static final String REMOVETEACHER_REQUEST_URL = "http://tutorialmanasys.site88.net/removeTeacher.php";
    private Map<String, String> params;

    public removeTeacherDB(String username, Response.Listener<String> listener) {
        super(Request.Method.POST, REMOVETEACHER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
