package com.example.brend.haven2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthorizationFlow extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private static boolean LOGIN_FLAG = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DEBUG", "AuthorizationFlow onCreate");
        FirebaseApp.initializeApp(this);

        setContentView(R.layout.activity_authorization_flow);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("DEBUG", "AuthorizationFlow onStart");
            // Check if user is signed in (non-null) and update UI accordingly.
        if(!LOGIN_FLAG) {
            FirebaseUser currentUser = mAuth.getCurrentUser();
            updateUI(currentUser);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("DEBUG", "AuthorizationFlow onNewIntent");


        Bundle extras = intent.getExtras();
        Log.d("DEBUG", extras.getString("METHOD"));

        switch(extras.getString("METHOD")) {
            case "updateUI":
                Task createResult = mAuth.createUserWithEmailAndPassword(
                        extras.getString("USERNAME"), extras.getString("PASSWORD"));
                FirebaseUser newUser = mAuth.getCurrentUser();
                updateUI(newUser);
                break;
            case "logIn":
                Log.d("DEBUG", "AuthorizationFlow onNewIntent case logIn");
                LOGIN_FLAG = true;
                logIn(extras);
                break;
            case "logOut":
                LOGIN_FLAG = false;
                logOut();
                break;
        }
    }
    /**
     * Controls whether to launch into user account or send them to login/register
     * @param cU - the currentUser sent from onStart() method
     */
    public void updateUI(FirebaseUser cU){
        Log.d("DEBUG", "AuthorizationFlow updateUI");

        if(cU != null){
            Log.d("DEBUG", "AuthorizationFlow Current User Populated");

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Log.d("DEBUG", "AuthorizationFlow Current User Null");

            Intent loginFlow = new Intent(this, LoginScreen.class);
            startActivity(loginFlow);
        }
    }

    public void logIn(Bundle extras){
        Log.d("DEBUG", "AuthorizationFlow logIn");

        mAuth.signInWithEmailAndPassword(
                extras.getString("USERNAME"),extras.getString("PASSWORD"));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
    public void logOut(){
        Log.d("DEBUG", "AuthorizationFlow logOut");
        mAuth.signOut();
        Intent intent = new Intent(this, LoginScreen.class);
        startActivity(intent);
    }
}
