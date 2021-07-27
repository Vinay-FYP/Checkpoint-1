package com.example.loginregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
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

public class Register extends AppCompatActivity {

    EditText name, emailAdd, password, phone;
    Button register;
    TextView login;
    ProgressBar progressBar;
    FirebaseAuth fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.fullName);
        emailAdd = (EditText) findViewById(R.id.emailAddress);
        password = (EditText) findViewById(R.id.password);
        phone = (EditText) findViewById(R.id.mobileNumber);
        register = (Button) findViewById(R.id.RegisterBtn);
        login = (TextView) findViewById(R.id.Login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        // getting the current instance of DB from firebase
        fb = FirebaseAuth.getInstance();

        //Check if the user is already logged in
        if(fb.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAdd.getText().toString().trim();
                String pword = password.getText().toString().trim();
                String fname = name.getText().toString().trim();
                String num = phone.getText().toString().trim();

                //Drawable icon = getResources().getDrawable(R.drawable.ic_error_icon);
                Drawable error = getResources().getDrawable(R.drawable.error_icon);

                //Check if name is empty
                if(TextUtils.isEmpty(fname)){
                    name.requestFocus();
                    name.setError("Your name is required",error);
                    return;
                }

                //Check email is empty
                if(TextUtils.isEmpty(email)){
                    emailAdd.requestFocus();
                    emailAdd.setError("An email address is required",error);
                    return;
                }
                //CHeck password is empty
                if (TextUtils.isEmpty(pword)) {
                    password.requestFocus();
                    password.setError("A password is required",error);
                    return;
                }
                //Check length of password
                if(pword.length()< 6){
                    password.requestFocus();
                    password.setError("Must be 6 characters or more",error);
                    return;
                }
                if(TextUtils.isEmpty(num)){
                    phone.requestFocus();
                    phone.setError("A mobile number is required",error);
                    return;
                }

                //make the spinner visible to user
                progressBar.setVisibility(View.VISIBLE);

                //Register the user in firebase
                fb.createUserWithEmailAndPassword(email,pword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //if registered successsfully
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Account Created", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i);
                            //startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        //Not registered
                        else {
                            Toast.makeText(Register.this,"Encountered Error" + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });
    }
}