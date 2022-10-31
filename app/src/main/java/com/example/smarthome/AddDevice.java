package com.example.smarthome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
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
            addDevice();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public  void addDevice(){
        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(AddDevice.this);
        builder.setTitle("Hi");                // Add customization options here
        builder.setTitle("yes");
//        builder

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
    public void onPointerCaptureChanged(boolean hasCapture){
    }
}