package com.example.awesomekid.tutorialms;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class AddTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_teacher);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etContactNum = (EditText) findViewById(R.id.etContactNum);
        final Button bAdd = (Button) findViewById(R.id.bAddStudent);


        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final String username = etUsername.getText().toString();
                final String password = "default";
                final String title = "teacher";
                final String contact_no = "+601" + etContactNum.getText().toString();

                if (TextUtils.isEmpty(username)) {
                    etUsername.setError("Input Username");
                }

                if (TextUtils.isEmpty(etContactNum.getText().toString())) {
                    etContactNum.setError("Input Phone Number");
                } else {


                        final Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonResponse = new JSONObject(response);
                                    boolean success = jsonResponse.getBoolean("success");
                                            if (success) {
                                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AddTeacher.this);
                                                alertDialog.setTitle("Add Teacher");
                                                alertDialog.setMessage("Teacher " + username + " added");
                                                alertDialog.setPositiveButton("OK", null)
                                                        .create()
                                                        .show();

                                            }else {
                                                AlertDialog.Builder builder = new AlertDialog.Builder(AddTeacher.this);
                                                builder.setMessage("Username '" +username+ "' Already Taken")
                                                        .setNegativeButton("Retry", null)
                                                        .create()
                                                        .show();
                                            }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }



                                etUsername.setText("");
                                etContactNum.setText("");

                            }

                        };





                    addUserDB addUserDB = new addUserDB(username, password, title, contact_no, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(AddTeacher.this);
                    queue.add(addUserDB);
                    }




                }

        });



    }
}
