package com.example.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    EditText emailAddress, password;
    TextView create;
    Button login;
    ProgressBar pbar;
    FirebaseAuth fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailAddress = (EditText) findViewById(R.id.emailAddress);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.LoginBtn);
        pbar =  (ProgressBar) findViewById(R.id.progressBar);
        create = (TextView) findViewById(R.id.Login);
        fb = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAddress.getText().toString().trim();
                String pass = password.getText().toString().trim();

                //Drawable error = getResources().getDrawable(R.drawable.error_icon);

                if(TextUtils.isEmpty(email)){
                    emailAddress.requestFocus();
                    emailAddress.setError("Email Required");
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    password.requestFocus();
                    password.setError("Password Required");
                    return;

                }
                if(pass.length() < 6){
                    password.requestFocus();
                    password.setError("Password must be at least 6 characters");
                    return;
                }

                pbar.setVisibility(View.VISIBLE);

                //authenticate user
                fb.signInWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT);
                            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);

                        }
                        if(!task.isSuccessful()){
                            Toast.makeText(Login.this, "error occured" + task.getException().getMessage(), Toast.LENGTH_LONG);
                            pbar.setVisibility(View.INVISIBLE);
                        }
                    }
                });

            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });

    }//End on Create
}