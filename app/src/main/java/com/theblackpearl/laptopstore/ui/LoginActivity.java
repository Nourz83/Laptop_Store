package com.theblackpearl.laptopstore.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.theblackpearl.laptopstore.MainActivity;
import com.theblackpearl.laptopstore.R;
import com.theblackpearl.laptopstore.Services;
import com.theblackpearl.laptopstore.dataManagement.DataBaseHelper;
import com.theblackpearl.laptopstore.models.User;
import com.theblackpearl.laptopstore.ui.admin.AdminMenu;
import com.theblackpearl.laptopstore.ui.user.UserMenu;

public class LoginActivity extends AppCompatActivity {
    EditText username , password;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        button = findViewById(R.id.login_button);
        setInteractions();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(LoginActivity.this , Splash.class);
        startActivity(intent);
        finish();
    }

    void setInteractions()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userdata = username.getText().toString();
                String passwordData = password.getText().toString();
                User user = new User();
                user.setUserName(userdata);
                user.setPassword(passwordData);
                try {
                    int state = Services.login(user , getApplicationContext());
                    if(state == 0 || state == 1 )
                    {
                      if(state == 0)
                      {
                          Intent intent = new Intent(LoginActivity.this, AdminMenu.class);
                          startActivity(intent);
                          finish();
                      }else{
                          Intent intent = new Intent(LoginActivity.this, UserMenu.class);
                          startActivity(intent);
                          finish();
                      }
                    }else{
                        Snackbar.make(v , "Wrong Credentials" , Snackbar.LENGTH_LONG).show();
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.toString());
                }
            }
        });
    }

}