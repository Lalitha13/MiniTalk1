package com.example.lalithanjali.minitalk;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private EditText pwd, email;
    private String password, Email;
    private Button registerButton;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        registerButton = findViewById(R.id.register);
        pwd = findViewById(R.id.password);
        email = findViewById(R.id.emailId);

        firebaseAuth = FirebaseAuth.getInstance();

        registerButton.setOnClickListener(this);
    }
    private void registerUser(){
        Email = email.getText().toString().trim();
        password = pwd.getText().toString().trim();

        if(TextUtils.isEmpty(Email)){
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return;
        }
        //progressDialog.setMessage("Registering User....");
        //progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(Register.this, Login.class);
                    startActivity(myIntent);
                    finish();
                }
                else{
                    Toast.makeText(Register.this, "Couldn't Register.Try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        if (v == registerButton) {
            registerUser();
        }
    }
}

