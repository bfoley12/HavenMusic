/**
 * Haven Programming Team
 * Brendan Foley, Nicholas Barranco, Raymond Santiago, Alex Reyes
 * Started: 1/7/2019
 *
 * Music streaming app aimed at increasing revenue for artists on streaming platforms
 *
 * This file handles logging in and ensuring safe login data before checking Firebase
 */
package com.example.brend.haven2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DEBUG", "LoginScreen onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
    }

    public void login(View view){
        // TODO: Perform error checking for length of username and password (no more than 64 char.
        // TODO: (cont'd) as well as valid characters (alphanumeric and valid symbols)
        EditText un = findViewById(R.id.loginUsername);
        String username = un.getText().toString();
        EditText pw = findViewById(R.id.loginPassword);
        String password = pw.getText().toString();
        if(username.length() > 64 || username.length() == 0 ||
                password.length() > 64 || password.length() == 0){
            un.setText("");
            pw.setText("");
            Toast.makeText(this, "Ensure username and password are less than 64" +
                    " and longer than 6 characters", Toast.LENGTH_LONG).show();
        }
        else if(username.length() > 6) {
            Intent intent = new Intent(this, AuthorizationFlow.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
            intent.putExtra("METHOD", "logIn");
            intent.putExtra("USERNAME", username);
            intent.putExtra("PASSWORD", password);
            startActivity(intent);
        }
    }

    public void registerButtonClicked(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
