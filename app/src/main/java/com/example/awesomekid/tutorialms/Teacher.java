package com.example.awesomekid.tutorialms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Teacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);
        final TextView studentLink = (TextView) findViewById(R.id.studentLink);
        final TextView scheduleLink = (TextView) findViewById(R.id.scheduleLink);
        final TextView vstudentLink = (TextView) findViewById(R.id.view_studentLink);
        final TextView passwordLink = (TextView) findViewById(R.id.passwordLink);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");

        String message = "Hello, " + username + "";
        welcomeMessage.setText(message);

        final String etUsername = username;
        final String etPassword = password;

        // link for student page
        studentLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherIntent = new Intent(Teacher.this, TeacherStudent.class);
                Teacher.this.startActivity(teacherIntent);
            }
        });

        //link for schedule page
        scheduleLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherIntent = new Intent(Teacher.this, TeacherSchedule.class);
                Teacher.this.startActivity(teacherIntent);
            }
        });

        //link for view student page
        vstudentLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherIntent = new Intent(Teacher.this, TeacherViewStudent.class);
                Teacher.this.startActivity(teacherIntent);
            }
        });

        //link for password page
        passwordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername;
                final String password = etPassword;

                Intent teacherIntent = new Intent(Teacher.this, UpdatePassword.class);

                teacherIntent.putExtra("username", username);
                teacherIntent.putExtra("password", password);

                Teacher.this.startActivity(teacherIntent);
            }
        });
    }
}
