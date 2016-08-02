package com.example.awesomekid.tutorialms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminSubject extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_subject);

        final Button bAddSubject = (Button) findViewById(R.id.bAddSubject);
        final Button bRemoveSubject = (Button) findViewById(R.id.bRemoveSubject);
        final Button bAssignTeacher = (Button) findViewById(R.id.bAssignTeacher);
        final Button bAssignStudent = (Button) findViewById(R.id.bAssignStudent);

        bAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminSubject.this, AddSubject.class);
                AdminSubject.this.startActivity(intent);
            }
        });

        bRemoveSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminSubject.this, RemoveSubject.class);
                AdminSubject.this.startActivity(intent);
            }
        });

        bAssignTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminSubject.this, AssignTeacher.class);
                AdminSubject.this.startActivity(intent);
            }
        });

        bAssignStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminSubject.this, AssignStudent.class);
                AdminSubject.this.startActivity(intent);
            }
        });
    }
}
