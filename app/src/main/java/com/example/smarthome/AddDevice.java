package com.example.smarthome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class AddDevice extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private
    Toolbar toolbar;
    DrawerLayout drawer;
    NavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);


        try {
            toolbar=findViewById(R.id.topAppBar);
            setSupportActionBar(toolbar);

            drawer =findViewById(R.id.drawerlayout);
            navigation=findViewById(R.id.navigationcom);
            ActionBarDrawerToggle actionBarDrawerToggle =new ActionBarDrawerToggle(
                    this,
                    drawer,
                    toolbar,
                    R.string.openNavDrawer,
                    R.string.closeNavDrawer
            );
            drawer.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();
            navigation.setNavigationItemSelectedListener(this);
            floatButton();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void floatButton(){
        FloatingActionButton floatbtn=(FloatingActionButton) findViewById(R.id.floating_action_button);
        floatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(AddDevice.this);
                builder.setTitle("Hi");                // Add customization options here
                builder.setMessage("Getting a new phone or tablet is exciting. But, you’ll have to go through the long process of transferring your data, apps, and accounts over to the new device. When you add a device to your existing Google Play account, you can transfer apps, games, and even game progress.");
                builder.show();
            }
        });
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
    public void onPointerCaptureChanged(boolean hasCapture){
    }
}