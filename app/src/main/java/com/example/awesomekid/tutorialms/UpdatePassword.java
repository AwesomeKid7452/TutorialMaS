package com.example.awesomekid.tutorialms;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class UpdatePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);

        final EditText etOldPassword = (EditText) findViewById(R.id.etOldPassword);
        final EditText etNewPassword = (EditText) findViewById(R.id.etNewPassword);
        final EditText etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        final Button bPassword = (Button) findViewById(R.id.bPassword);

        Intent intent = getIntent();
        final String getusername = intent.getStringExtra("username");
        final String getpassword = intent.getStringExtra("password");
        

        bPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etOldPassword.getText().toString())) {
                    etOldPassword.setError("Input Username");
                }

                if (TextUtils.isEmpty(etNewPassword.getText().toString())) {
                    etNewPassword.setError("Input Password");
                } else {
                    if (getpassword.equals(etOldPassword.getText().toString())) {
                        final String username = getusername;
                        final String OldPassword = etOldPassword.getText().toString();
                        final String password = etNewPassword.getText().toString();
                        final String ConfirmPassword = etConfirmPassword.getText().toString();

                        if (password.length() < 6) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePassword.this);
                            builder.setMessage("Password length must more than 6 characters")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                        }else {

                            if (password.equals(getpassword)) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePassword.this);
                                builder.setMessage("New password cannot be similar as current password")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            } else {


                                if (ConfirmPassword.equals(password.toString())) {


                                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            try {
                                                JSONObject jsonResponse = new JSONObject(response);
                                                final boolean success = jsonResponse.getBoolean("success");

                                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(UpdatePassword.this);
                                                alertDialog.setTitle("Password Update");
                                                alertDialog.setMessage("Password has been updated");
                                                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        if (success) {
                                                            Intent intent = new Intent(UpdatePassword.this, TutorialMS.class);
                                                            UpdatePassword.this.startActivity(intent);
                                                        }

                                                    }
                                                })
                                                        .create()
                                                        .show();


                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                            etOldPassword.setText("");
                                            etNewPassword.setText("");
                                            etConfirmPassword.setText("");

                                        }
                                    };
                                    PasswordRequest passwordRequest = new PasswordRequest(username, OldPassword, password, ConfirmPassword, responseListener);
                                    RequestQueue queue = Volley.newRequestQueue(UpdatePassword.this);
                                    queue.add(passwordRequest);

                                } else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePassword.this);
                                    builder.setMessage("Password confirmation not matched")
                                            .setNegativeButton("Retry", null)
                                            .create()
                                            .show();
                                }
                            }
                        }

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(UpdatePassword.this);
                        builder.setMessage("Password Update Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();

                    }
                }
            }
        });
    }
}
