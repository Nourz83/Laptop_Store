package com.theblackpearl.laptopstore;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.theblackpearl.laptopstore.ui.Splash;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this , Splash.class);
        startActivity(intent);
        this.finish();
    }
}