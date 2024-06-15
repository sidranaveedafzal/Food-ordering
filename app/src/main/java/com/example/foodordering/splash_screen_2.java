package com.example.foodordering;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splash_screen_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen2);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Once your animation is complete, you can export it in JSON format. In After Effects, you can use plugins like Bodymovin to export animations in JSON format.
                //Save the exported JSON file to your computer

                Intent i = new Intent(splash_screen_2.this, onboard1.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }
}