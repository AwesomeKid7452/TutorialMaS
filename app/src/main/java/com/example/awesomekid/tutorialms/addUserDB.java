package com.example.awesomekid.tutorialms;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AwesomeKid on 20/07/16.
 */
public class addUserDB extends StringRequest {
    private static final String TEACHER_REQUEST_URL = "http://tutorialmanasys.site88.net/addUser.php";
    private Map<String, String> params;

    public addUserDB(String username, String password, String title, String contact_no, Response.Listener<String> listener) {
        super(Request.Method.POST, TEACHER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
        params.put("title", title);
        params.put("contact_no", contact_no);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
