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
        FirebaseApp.initializeApp(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization_flow);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onStart() {
        FirebaseApp.initializeApp(this);
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        Task createResult = mAuth.createUserWithEmailAndPassword(
                extras.getString("USERNAME"), extras.getString("PASSWORD"));
        FirebaseUser newUser = mAuth.getCurrentUser();
        Log.i("HELLO", "" + createResult.getResult());
        updateUI(newUser);
    }
    /**
     * Controls whether to launch into user account or send them to login/register
     * @param cU - the currentUser sent from onStart() method
     */
    public void updateUI(FirebaseUser cU){
        if(cU != null){
            //TODO: Link to the user's account
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Intent loginFlow = new Intent(this, LoginScreen.class);
            startActivity(loginFlow);
        }
    }
}
