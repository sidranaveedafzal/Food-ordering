package com.example.foodordering;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Enter_phonenum extends AppCompatActivity {
    EditText phoneNumber;
    String phone;
    Button next;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enter_phonenum);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        phoneNumber = findViewById(R.id.eGet_ph_num);

        Intent intent = getIntent();
        phone = intent.getStringExtra("phoneNumber");

        if (phone != null){
            phoneNumber.setText(phone);
        } else {
            Toast.makeText(this, "No Number", Toast.LENGTH_SHORT).show();
        }

        next=findViewById(R.id.next_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(Enter_phonenum.this,OTP_verification.class);
                startActivity(obj);
            }
        });

    }
}