package com.example.awesomekid.tutorialms;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
        final EditText etContact_No = (EditText) findViewById(R.id.etContact_No);
        final Button bAdd = (Button) findViewById(R.id.bAddStudent);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = etUsername.getText().toString();
                final String password = "default";
                final String title = "student";
                final String contact_no = "+601" + etContact_No.getText().toString();

                final Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AddStudent.this);
                                alertDialog.setTitle("Add Student");
                                alertDialog.setMessage("Student " + username + " added");
                                alertDialog.setPositiveButton("OK", null)
                                        .create()
                                        .show();

                            }else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(AddStudent.this);
                                builder.setMessage("Username '" +username+ "' Already Taken")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                        etUsername.setText("");
                        etContact_No.setText("");

                    }

                };

                addUserDB addUserDB = new addUserDB(username, password, title, contact_no, responseListener);
                RequestQueue queue = Volley.newRequestQueue(AddStudent.this);
                queue.add(addUserDB);
            }


        });


    }
}
