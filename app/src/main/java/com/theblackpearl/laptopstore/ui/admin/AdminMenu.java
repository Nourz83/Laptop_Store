package com.theblackpearl.laptopstore.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.theblackpearl.laptopstore.R;
import com.theblackpearl.laptopstore.Services;
import com.theblackpearl.laptopstore.ui.Splash;

public class AdminMenu extends AppCompatActivity {
    Button btnViewLaptop , btnAddLaptop , btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        btnViewLaptop = findViewById(R.id.view_laptop);
        btnAddLaptop = findViewById(R.id.add_laptop_button);
        btnLogout = findViewById(R.id.logout);
        startListener();
    }
    void startListener(){
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.logout(getApplicationContext());
                Intent intent = new Intent(AdminMenu.this , Splash.class);
                startActivity(intent);
                finish();
            }
        });
    }
}