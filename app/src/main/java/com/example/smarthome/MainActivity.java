package com.example.smarthome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splashScreen();
    }
    public  void splashScreen(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i= new Intent(MainActivity.this,signup.class);
                startActivity(i); //start new activity
                finish();
            }
        }, 10000);
    }
}