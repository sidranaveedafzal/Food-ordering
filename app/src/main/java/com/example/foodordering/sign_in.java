package com.example.foodordering;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class sign_in extends AppCompatActivity {
    EditText et_username, et_pass;
    CheckBox show;
    ProgressDialog mdialog;
    FirebaseAuth mAuth;
    Button sigin_btn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        sigin_btn=findViewById(R.id.signin_btn);
        et_username=findViewById(R.id.et_user);
        et_pass=findViewById(R.id.et_pass);

        sigin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_pass.getText().toString();

                if (password.isEmpty() || username.isEmpty()) {
                    Toast.makeText(sign_in.this, "Enter details", Toast.LENGTH_SHORT).show();
                } else if (!password.contains("@gmail.com")) {
                    Toast.makeText(sign_in.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                } else {
                    SignIn(username,password);
                    Intent obj = new Intent(sign_in.this, OTP_verification.class);
                    startActivity(obj);
                }

            }
        });

    }

    private void SignIn(String username, String password) {
        mAuth = FirebaseAuth.getInstance();
        mdialog.setTitle("Logging in");
        mdialog.setMessage("Processing");
        mdialog.show();
        mAuth.signInWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    mdialog.dismiss();
                    Toast.makeText(sign_in.this, "Welcome back", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                mdialog.dismiss();
                Toast.makeText(sign_in.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}
