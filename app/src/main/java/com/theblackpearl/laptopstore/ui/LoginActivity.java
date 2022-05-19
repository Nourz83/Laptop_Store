package com.theblackpearl.laptopstore.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.theblackpearl.laptopstore.R;
import com.theblackpearl.laptopstore.dataManagement.DataBaseHelper;
import com.theblackpearl.laptopstore.models.User;

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
                    int state = checkData(user);
                    if(state == 0 || state == 1 )
                    {

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
    int checkData(User user){
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        if(user.getUserName().equals("admin") && user.getPassword().equals("admin"))
        {
            return  0;
        }
        User user1 = dataBaseHelper.getUser(user);
        if(user1 != null)
        {
            return 1;
        }
        else{
            return 2;
        }
    }
}