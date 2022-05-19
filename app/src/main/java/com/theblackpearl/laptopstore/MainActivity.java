package com.theblackpearl.laptopstore;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.theblackpearl.laptopstore.dataManagement.SharedPreferenceHelper;
import com.theblackpearl.laptopstore.models.User;
import com.theblackpearl.laptopstore.ui.Splash;
import com.theblackpearl.laptopstore.ui.admin.AdminMenu;
import com.theblackpearl.laptopstore.ui.user.UserMenu;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferenceHelper sharedPreferenceHelper = new SharedPreferenceHelper(getApplicationContext());
        User user = sharedPreferenceHelper.getUser();
        if(user == null) {
            Intent intent = new Intent(MainActivity.this, Splash.class);
            startActivity(intent);
            this.finish();
        }else{
            System.out.println(user.getUserName());
            System.out.println(user.getPassword());
            System.out.println(sharedPreferenceHelper.getType());
            if(sharedPreferenceHelper.getType())
            {
                Intent intent = new Intent(MainActivity.this, AdminMenu.class);
                startActivity(intent);
            }
            else{
                Intent intent = new Intent(MainActivity.this, UserMenu.class);
                startActivity(intent);
            }
            this.finish();
        }
    }
}