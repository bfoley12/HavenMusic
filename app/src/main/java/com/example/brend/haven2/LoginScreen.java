/**
 * Haven Programming Team
 * Brendan Foley, Nicholas Barranco, Raymond Santiago, Alex Reyes
 * Started: 1/7/2019
 *
 * Music streaming app aimed at increasing revenue for artists on streaming platforms
 *
 * This file handles logging in and ensuring safe login data before checking SQL Database
 */
package com.example.brend.haven2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        // TODO: Create SQL DB and check for the now found username and password pair, if valid
        // TODO: (cont'd) then progress to MainActivity, otherwise Toast incorrect and retry
    }
}
