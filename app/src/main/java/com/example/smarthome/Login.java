package com.example.smarthome;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signupRoute();
        loginUser();
    }
    protected  void  loginUser(){
        Button login =(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                Log.d("click","click");

                TextInputEditText email=(TextInputEditText) findViewById(R.id.email_text);
                TextInputEditText password=(TextInputEditText) findViewById(R.id.password_text);
                String emailtext=email.getText().toString().trim();
                String passwordtext=password.getText().toString().trim();

                Log.d("data1",emailtext+ mAuth.toString() +passwordtext);

                if(emailtext.isEmpty()){
                    email.setError("Email is Require");
                    email.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(emailtext).matches()){
                    email.setError("Not A Valid Email");
                    email.requestFocus();
                    return;
                }
                if(passwordtext.isEmpty()){
                    password.setError("Password is Required");
                    password.requestFocus();
                    return;
                }

                Log.d("valid","validation");

                mAuth.signInWithEmailAndPassword(emailtext, passwordtext)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("tak",Boolean.toString(task.isSuccessful()));
                                if (task.isSuccessful()) {
                                    Intent i= new Intent(Login.this,AddDevice.class );
                                    startActivity(i); //start new activity
                                    finish();         // Sign in success, update UI with the signed-in user's information

                                } else {
                                    // If sign in fails, display a message to the user.
//                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
//                                    Toast.makeText(EmailPasswordActivity.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                                }
                            }
                        });

            }
        });


    }
    protected  void moveRoute(){
        Button login =(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent i= new Intent(Login.this,AddDevice.class);
                startActivity(i); //start new activity
                finish();
                // Functionality for the button...
            }
        });

    }
    protected void signupRoute(){
        Button signup =(Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(Login.this,signup.class);
                startActivity(i); //start new activity
                finish();
                // Functionality for the button...
            }
        });
    }
}