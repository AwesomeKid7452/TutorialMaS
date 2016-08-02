package com.example.awesomekid.tutorialms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_teacher);

        final Button bAddTeacher = (Button) findViewById(R.id.bAddTeacher);
        final Button bRemoveTeacher = (Button) findViewById(R.id.bRemoveTeacher);

        //link for Add Teacher page
        bAddTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTeacher.this, AddTeacher.class);
                AdminTeacher.this.startActivity(intent);
            }
        });

        //link for Remove Teacher page
        bRemoveTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTeacher.this, RemoveTeacher.class);
                AdminTeacher.this.startActivity(intent);
            }
        });
    }
}
