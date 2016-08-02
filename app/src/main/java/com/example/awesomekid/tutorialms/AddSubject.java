package com.example.awesomekid.tutorialms;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class AddSubject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        final EditText etSubjectName = (EditText) findViewById(R.id.etSubjectName);
        final EditText etLevel = (EditText) findViewById(R.id.etLevel);
        final EditText etFess = (EditText) findViewById(R.id.etFees);
        final Button bNext = (Button) findViewById(R.id.bNext);

        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String subject_name = etSubjectName.getText().toString();
                final String level = "Standard " + etLevel.getText().toString();

                final Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(AddSubject.this);
                                builder.setMessage(subject_name + " Already Taken")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            } else {
                                Intent intent = new Intent(AddSubject.this, AddSubject2.class);

                                intent.putExtra("subject_name", subject_name);
                                intent.putExtra("level", level);

                                AddSubject.this.startActivity(intent);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };


                checkSubject checkSubject = new checkSubject(subject_name, level, responseListener);
                RequestQueue queue = Volley.newRequestQueue(AddSubject.this);
                queue.add(checkSubject);
            }
        });

    }
}
