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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DEBUG", "AuthorizationFlow onCreate");
        FirebaseApp.initializeApp(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization_flow);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        Log.d("DEBUG", "AuthorizationFlow onStart");
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("DEBUG", "AuthorizationFlow onNewIntent");
        super.onNewIntent(intent);

        Bundle extras = intent.getExtras();
        Task createResult = mAuth.createUserWithEmailAndPassword(
                extras.getString("USERNAME"), extras.getString("PASSWORD"));
        FirebaseUser newUser = mAuth.getCurrentUser();
        updateUI(newUser);
    }
    /**
     * Controls whether to launch into user account or send them to login/register
     * @param cU - the currentUser sent from onStart() method
     */
    public void updateUI(FirebaseUser cU){
        Log.d("DEBUG", "AuthorizationFlow updateUI");

        if(cU != null){
            Log.d("DEBUG", "AuthorizationFlow Current User Populated");

            //TODO: Link to the user's account
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Log.d("DEBUG", "AuthorizationFlow Current User Null");

            Intent loginFlow = new Intent(this, LoginScreen.class);
            startActivity(loginFlow);
        }
    }
}
