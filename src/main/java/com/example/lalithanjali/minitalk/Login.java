package com.example.lalithanjali.minitalk;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText emailId,pwd;
    private String Email,password;
    private FirebaseAuth firebaseAuth;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        emailId = findViewById(R.id.email);
        pwd = findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login1);
        firebaseAuth = FirebaseAuth.getInstance();
        loginButton.setOnClickListener(this);
    }

        private void loginUser(){
            Email = emailId.getText().toString().trim();
            password = pwd.getText().toString().trim();

            if(TextUtils.isEmpty(Email)){
                Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(password)){
                Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
                return;
            }
            firebaseAuth.signInWithEmailAndPassword(Email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(Login.this, "Not Registered", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent myIntent = new Intent(Login.this, Categories.class);
                        startActivity(myIntent);
                        finish();
                    }
                }
            });
        }


        @Override
        public void onClick(View v) {
            if (v == loginButton) {
                loginUser();
            }
        }

    }
