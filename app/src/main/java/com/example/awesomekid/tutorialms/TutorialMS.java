package com.example.awesomekid.tutorialms;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class TutorialMS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_ms);
        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.bLogin);

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    etUsername.setError("Input Username");
                }

                    if (TextUtils.isEmpty(password)) {
                        etPassword.setError("Input Password");
                    } else {
                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonResponse = new JSONObject(response);
                                    boolean success = jsonResponse.getBoolean("success");

                                    if (success) {
                                        String title = jsonResponse.getString("title");

                                        if (title.equals("teacher")) {
                                            Intent intent = new Intent(TutorialMS.this, Teacher.class);

                                            intent.putExtra("username", username);
                                            intent.putExtra("password", password);

                                            TutorialMS.this.startActivity(intent);
                                        } else if (title.equals("student")) {
                                            Intent intent = new Intent(TutorialMS.this, Student.class);

                                            intent.putExtra("username", username);
                                            intent.putExtra("password", password);

                                            TutorialMS.this.startActivity(intent);
                                        } else if (title.equals("admin")) {
                                            Intent intent = new Intent(TutorialMS.this, Admin.class);

                                            intent.putExtra("username", username);
                                            intent.putExtra("password", password);

                                            TutorialMS.this.startActivity(intent);
                                        }
                                    } else {
                                        AlertDialog.Builder builder = new AlertDialog.Builder(TutorialMS.this);
                                        builder.setMessage("Login Failed")
                                                .setNegativeButton("Retry", null)
                                                .create()
                                                .show();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                etUsername.setText("");
                                etPassword.setText("");
                            }
                        };
                        LoginRequest teacherPage = new LoginRequest(username, password, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(TutorialMS.this);
                        queue.add(teacherPage);
                    }
                }

        });

    }
}
