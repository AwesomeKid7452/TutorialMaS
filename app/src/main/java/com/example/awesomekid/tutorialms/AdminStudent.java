package com.example.awesomekid.tutorialms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_student);

        final Button bAddStudent = (Button) findViewById(R.id.bAddStudent);
        final Button bRemoveStudent = (Button) findViewById(R.id.bRemoveStudent);

        //link for Add Teacher page
        bAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStudent.this, AddStudent.class);
                AdminStudent.this.startActivity(intent);
            }
        });

        //link for Remove Teacher page
        bRemoveStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminStudent.this, RemoveStudent.class);
                AdminStudent.this.startActivity(intent);
            }
        });
    }
}
