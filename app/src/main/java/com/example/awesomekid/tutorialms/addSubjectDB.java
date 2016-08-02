package com.example.awesomekid.tutorialms;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AwesomeKid on 28/07/16.
 */
public class addSubjectDB extends StringRequest {
    private static final String SUBJECT_REQUEST_URL = "http://tutorialmanasys.site88.net/addSubject.php";
    private Map<String, String> params;

    public addSubjectDB(String subject_name, double fees, String venue, Response.Listener<String> listener) {
        super(Request.Method.POST, SUBJECT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("subject_name", subject_name);
        params.put("fees", fees + "");
        params.put("venue", venue);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
