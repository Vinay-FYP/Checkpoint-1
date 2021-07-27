 package com.example.firebase_log_reg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private TextView register;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         register = findViewById(R.id.register);
         register.setOnClickListener(this);
     }

     @Override
     public void onClick(View v) {
         //if the register button is clicked
         switch (v.getId()){
             case R.id.register:
                 startActivity(new Intent(this, RegisterUser.class));
         }
     }
 }