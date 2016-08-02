package com.example.awesomekid.tutorialms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMsg);
        final TextView teacherLink = (TextView) findViewById(R.id.teacherLink);
        final TextView studentLink = (TextView) findViewById(R.id.studentLink);
        final TextView subjectLink = (TextView) findViewById(R.id.subjectLink);
        final TextView paymentLink = (TextView) findViewById(R.id.paymentLink);
        final TextView scheduleLink = (TextView) findViewById(R.id.scheduleLink);
        final TextView passwordLink = (TextView) findViewById(R.id.passwordLink);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");

        String message = "Hello Welcome Admin, " + username + "";
        welcomeMessage.setText(message);

        final String etUsername = username;
        final String etPassword = password;

        //link for teacher page
        teacherLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent teacherIntent = new Intent(Admin.this, AdminTeacher.class);
                Admin.this.startActivity(teacherIntent);
            }
        });

        //link for student page
        studentLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentIntent = new Intent(Admin.this, AdminStudent.class);
                Admin.this.startActivity(studentIntent);
            }
        });

        //link for subject page
        subjectLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent subjectIntent = new Intent(Admin.this, AdminSubject.class);
                Admin.this.startActivity(subjectIntent);
            }
        });

        //link for payment page
        paymentLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent paymentIntent = new Intent(Admin.this, AdminPayment.class);
                Admin.this.startActivity(paymentIntent);
            }
        });

        //link for schedule page
        scheduleLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scheduleIntent = new Intent(Admin.this, AdminSchedule.class);
                Admin.this.startActivity(scheduleIntent);
            }
        });

        //link for password page
        passwordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = etUsername;
                final String password = etPassword;

                Intent scheduleIntent = new Intent(Admin.this, UpdatePassword.class);
                scheduleIntent.putExtra("username", username);
                scheduleIntent.putExtra("password", password);

                Admin.this.startActivity(scheduleIntent);
            }
        });




    }
}
