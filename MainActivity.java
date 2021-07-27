package com.example.ui_tutorial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private  TextView txtHello;
    private  EditText edtTxtName;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnHello:
                Toast.makeText(this, "Hello button clicked", Toast.LENGTH_LONG).show();
                txtHello.setText("Hello " + edtTxtName.getText().toString());
                break;
            default:
                break;
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        btnHello.setOnClickListener(this);

         edtTxtName = findViewById(R.id.edtTxtName);
         txtHello = findViewById(R.id.txtHello);

    }


}