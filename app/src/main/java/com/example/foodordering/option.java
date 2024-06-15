package com.example.foodordering;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class option extends AppCompatActivity {
    ImageView icn1;
    TextView option_signup;
    Button sigin_btn_option;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_option);

        icn1 = findViewById(R.id.icn1);
        option_signup = findViewById(R.id.signup1);
        sigin_btn_option = findViewById(R.id.signin_btn_option);

        icn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(option.this,splash_screen_2.class);
                startActivity(obj);
            }
        });
        option_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(option.this,sign_up.class);
                startActivity(obj);
            }
        });
        sigin_btn_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(option.this,sign_in.class);
                startActivity(obj);
            }
        });

    }
}