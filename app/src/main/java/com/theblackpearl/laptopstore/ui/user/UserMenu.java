package com.theblackpearl.laptopstore.ui.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.theblackpearl.laptopstore.R;
import com.theblackpearl.laptopstore.Services;
import com.theblackpearl.laptopstore.dataManagement.SharedPreferenceHelper;
import com.theblackpearl.laptopstore.ui.Splash;

public class UserMenu extends AppCompatActivity {
    TextView textView;
    Button btnViewLaptop , logout;
    SharedPreferenceHelper sharedPreferenceHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);
        textView = findViewById(R.id.username_title);
        sharedPreferenceHelper = new SharedPreferenceHelper(getApplicationContext());
        String name = sharedPreferenceHelper.getUser().getName();
        textView.setText(name);
        textView.refreshDrawableState();
        btnViewLaptop = findViewById(R.id.view_laptop);
        logout = findViewById(R.id.logout);
        startListener();
    }
    void startListener()
    {
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.logout(getApplicationContext());
                Intent intent = new Intent(UserMenu.this , Splash.class);
                startActivity(intent);
                finish();
            }
        });
    }
}