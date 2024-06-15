package com.example.foodordering;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.foodordering.modelclass.AddDataToRealtimeDatabase_signup;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class sign_up extends AppCompatActivity {
    EditText et_phnum, et_username, et_pass;
    ImageView icn2;
    TextView option_signin;
    Button sigup_btn;

    FirebaseAuth mAuth;
    ProgressDialog dialog;

    FirebaseDatabase database;
    DatabaseReference ref;


    public sign_up() {

        mAuth = FirebaseAuth.getInstance();
        ref = FirebaseDatabase.getInstance().getReference();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);


        icn2 = findViewById(R.id.icn2);
        option_signin = findViewById(R.id.signin1);
        sigup_btn = findViewById(R.id.signup_btn);

        et_phnum=findViewById(R.id.et_1);
        et_username=findViewById(R.id.et_2);
        et_pass=findViewById(R.id.et_3);

        dialog = new ProgressDialog(sign_up.this);

        icn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(sign_up.this,option.class);
                startActivity(obj);
            }
        });
        option_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj = new Intent(sign_up.this,sign_in.class);
                startActivity(obj);
            }
        });
        sigup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String phone = et_phnum.getText().toString();
                String password = et_pass.getText().toString();

                if (password.isEmpty() || username.isEmpty()) {
                    Toast.makeText(sign_up.this, "Enter details", Toast.LENGTH_SHORT).show();
                } else {
                    SignUp(username,password, phone);

                }
            }
        });


    }

    private void AddDataToRealtimeDatabase(String username, String password, String phnum){
        AddDataToRealtimeDatabase_signup obj=new AddDataToRealtimeDatabase_signup(username,password, phnum);
        database=FirebaseDatabase.getInstance();
        ref = database.getReference("SIGN_UP");

        ref.child("Information").push().setValue(obj).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(sign_up.this, "Saved", Toast.LENGTH_SHORT).show();
                Intent obj = new Intent(sign_up.this,Enter_phonenum.class);
                obj.putExtra("phoneNumber",phnum);
                startActivity(obj);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(sign_up.this, "Something went wrong"+e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
    public void SignUp(String username, String password, String phone){
        mAuth = FirebaseAuth.getInstance();
        dialog.setTitle("Creating account");
        dialog.setMessage("Processing");
        dialog.show();
        mAuth.createUserWithEmailAndPassword(username,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    AddDataToRealtimeDatabase(username,password,phone);
                    dialog.dismiss();
                    Toast.makeText(sign_up.this, "Welcome user", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                dialog.dismiss();
                Toast.makeText(sign_up.this, "ERROR "+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
