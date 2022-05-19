package com.theblackpearl.laptopstore.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.theblackpearl.laptopstore.R;
import com.theblackpearl.laptopstore.dataManagement.DataBaseHelper;
import com.theblackpearl.laptopstore.models.User;

public class SignUpActivity extends AppCompatActivity {
    Button btn;
    EditText name , username , password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.nameEditor);
        password = findViewById(R.id.passowrd_sign_up);
        username = findViewById(R.id.username_editor);
        btn = findViewById(R.id.sign_up_form);
        startListener();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SignUpActivity.this , Splash.class);
        startActivity(intent);
        finish();
    }
    void startListener()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(0 ,  username.getText().toString() , password.getText().toString() , name.getText().toString());
                if(check(user))
                {

                    if(insertData(user)) {
                        Toast.makeText(getApplication().getBaseContext(), "Sign Up Successfully Use Ur Info To Log In", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignUpActivity.this, Splash.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Snackbar.make(v , "Username Exists" , Snackbar.LENGTH_LONG).show();
                    }
                }
                else{
                    Snackbar.make(v , "Error Data" , Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
    boolean check(User user)
    {
        return !user.getName().isEmpty() && !user.getPassword().isEmpty() && !user.getUserName().isEmpty();
    }
    boolean insertData(User user)
    {
        DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
        try {
            return dataBaseHelper.addUser(user);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return  false;
        }
    }
}