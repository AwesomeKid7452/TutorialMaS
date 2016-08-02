package com.example.awesomekid.tutorialms;

import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RemoveStudent extends AppCompatActivity {
    InputStream is = null;
    String line = null;
    String result = null;
    String temp = "";
    String[] arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_student);

        final Spinner spRemove = (Spinner) findViewById(R.id.spRemove);
        final Button bRemove = (Button) findViewById(R.id.bRemove);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().build();
        StrictMode.setThreadPolicy(policy);

        try {
            HttpClient httpClient = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost("http://tutorialmanasys.site88.net/studentList.php");
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

        } catch (Exception e) {
            //null
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null)
                sb.append(line + "\n");
            result = sb.toString();
            is.close();

        } catch (Exception e) {
            //null
        }

        try {
            JSONArray jArray = new JSONArray(result);
            int count = jArray.length();

            for (int i = 0; i < count; i++) {
                JSONObject json_data = jArray.getJSONObject(i);
                temp += json_data.getString("username") + ":";
            }

            arr = temp.split(":");
            spRemove.setAdapter(new ArrayAdapter<String>(RemoveStudent.this, android.R.layout.simple_expandable_list_item_1, arr));

        } catch (Exception e) {
            //null
        }

        bRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = spRemove.getSelectedItem().toString();
                final String title = "student";

                final Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder alertDialog = new AlertDialog.Builder(RemoveStudent.this);
                                alertDialog.setTitle("Remove Student");
                                alertDialog.setMessage("Student " + username + " successfully removed");
                                alertDialog.setPositiveButton("OK", null)
                                        .create()
                                        .show();

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                removeUserDB removeUserDB = new removeUserDB(username, title, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RemoveStudent.this);
                queue.add(removeUserDB);
            }
        });
    }
}

