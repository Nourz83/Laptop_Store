package com.theblackpearl.laptopstore.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Space;

import com.theblackpearl.laptopstore.R;
import com.theblackpearl.laptopstore.dataManagement.DataBaseHelper;

public class Splash extends AppCompatActivity {

    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        btn1 = findViewById(R.id.button_form1);
        btn2 = findViewById(R.id.button_form2);
        setButtons();


    }

    void setButtons()
    {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Splash.this , LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Splash.this , SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}