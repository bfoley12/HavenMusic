package com.example.brend.haven2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Temporary class
 * Will later check whether user is logged in with valid auth_token, and control flow to app vs login
 */
public class LaunchFlowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_flow);
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }
}
