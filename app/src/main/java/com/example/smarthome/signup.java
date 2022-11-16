package com.example.smarthome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    protected

    Button signup,login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        loginRoute();
        signupUser();
        Log.d("constructor","cons");

    }
    public void signupUser(){
        signup=(Button) findViewById(R.id.signup);
        Log.d("signup",signup.toString());

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                Log.d("click","click");

                TextInputEditText email=(TextInputEditText) findViewById(R.id.email_text);
                TextInputEditText password=(TextInputEditText) findViewById(R.id.password_text);
                TextInputEditText confirmPassword=(TextInputEditText) findViewById(R.id.confirmPassword_text);
                String emailtext=email.getText().toString().trim();
                String passwordtext=password.getText().toString().trim();
                String confirmpasswordtext=confirmPassword.getText().toString().trim();
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
                if(confirmpasswordtext.isEmpty()){
                    confirmPassword.setError("Confirm Password is Required");
                    confirmPassword.requestFocus();
                    return;
                }
                Log.d("pass",confirmpasswordtext+"   "+passwordtext);
                if(!passwordtext.equals(confirmpasswordtext)){
                    password.setError("Confirm Password and password does not match");
                    password.requestFocus();
                    confirmPassword.setError("Confirm Password and password does not match");
                    confirmPassword.requestFocus();
                    return;
                }
                Log.d("valid","validation");

                mAuth.createUserWithEmailAndPassword(emailtext, passwordtext)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("task1",Boolean.toString(task.isSuccessful()));
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent i= new Intent(signup.this,AddDevice.class );
                                    startActivity(i); //start new activity
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
//                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                                    Toast.makeText(signup.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
                                    Log.d("authentication","authentication issue");
                                }
                            }
                        });
            }
        });
    }
    protected void loginRoute(){
        login =(Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i= new Intent(signup.this, Login.class);
                startActivity(i); //start new activity
                finish();
                // Functionality for the button...
            }
        });
    }
}