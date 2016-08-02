package com.example.awesomekid.tutorialms;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by AwesomeKid on 18/07/16.
 */
public class PasswordRequest extends StringRequest{
    private static final String PASSWORD_REQUEST_URL = "http://tutorialmanasys.site88.net/password.php";
    private Map<String, String> params;

    public PasswordRequest(String username, String OldPassword, String password, String ConfirmPassword, Response.Listener<String> listener) {
        super(Request.Method.POST, PASSWORD_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("OldPassword", OldPassword);
        params.put("password", password);
        params.put("ConfirmPassword", ConfirmPassword);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
