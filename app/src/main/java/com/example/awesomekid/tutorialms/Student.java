package com.example.awesomekid.tutorialms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);
        final TextView scheduleLink = (TextView) findViewById(R.id.scheduleLink);
        final TextView paymentLink = (TextView) findViewById(R.id.paymentLink);
        final TextView teacherLink = (TextView) findViewById(R.id.teacherLink);
        final TextView passwordLink = (TextView) findViewById(R.id.passwordLink);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");

        String message = "Hello, " + username + "";
        welcomeMessage.setText(message);

        final String etUsername = username;
        final String etPassword = password;

        //link for schedule page
        scheduleLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherIntent = new Intent(Student.this, StudentSchedule.class);
                Student.this.startActivity(teacherIntent);
            }
        });

        //link for payment page
        paymentLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherIntent = new Intent(Student.this, StudentPayment.class);
                Student.this.startActivity(teacherIntent);
            }
        });

        //link for teacher page
        teacherLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherIntent = new Intent(Student.this, StudentTeacher.class);
                Student.this.startActivity(teacherIntent);
            }
        });

        //link for password page
        passwordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername;
                final String password = etPassword;

                Intent teacherIntent = new Intent(Student.this, UpdatePassword.class);

                teacherIntent.putExtra("username", username);
                teacherIntent.putExtra("password", password);

                Student.this.startActivity(teacherIntent);
            }
        });
    }
}
