/**
 * Haven Programming Team
 * Brendan Foley, Nicholas Barranco, Raymond Santiago, Alex Reyes
 * Started: 1/7/2019
 *
 * Music streaming app aimed at increasing revenue for artists on streaming platforms
 *
 * This file handles the Registration of new users
 */
package com.example.brend.haven2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    /**
     * Called on registerButton being pressed, takes info and if valid creates new user
     * @param view - the button (registerButton) that was clicked on
     */
    public void registerAccount(View view){
        EditText un = findViewById(R.id.registerUsername);
        EditText pw1 = findViewById(R.id.registerPassword);
        EditText pw2 = findViewById(R.id.registerPassword2);

        String username = un.getText().toString();
        String password1 = pw1.getText().toString();
        String password2 = pw2.getText().toString();

        if(username.length() > 64 || password1.length() >64 || password2.length() > 64) {
            Toast.makeText(this, "All entries must be less than 64 characters",
                    Toast.LENGTH_SHORT).show();
            un.setText("");
            pw1.setText("");
            pw2.setText("");
        }
        else if(!password1.equals(password2)){
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            pw1.setText("");
            pw2.setText("");
        }
        else{
            // TODO: Create new user entry in database
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
