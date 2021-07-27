package com.example.regtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnRegister(View view){
        //define text views
        TextView txtFname = findViewById(R.id.txtFname);
        TextView txtLname = findViewById(R.id.txtLname);
        TextView txtEmail = findViewById(R.id.txtEmail);

        //Define edit texts
        EditText firstName = findViewById(R.id.editTextFname);
        EditText lastName = findViewById(R.id.editTextLname);
        EditText email = findViewById(R.id.editTextEmail);


        //set the text off the text vies on the btn click for register
        txtFname.setText("First Name : " + firstName.getText().toString());
        txtLname.setText("Last Name : " + lastName.getText().toString());
        txtEmail.setText("Email : " + email.getText().toString());
    }
}