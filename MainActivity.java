package com.example.uibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean click = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //another way of creating on click listener
        Button btnHello = findViewById(R.id.btnHello);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hello");
                click = true;


            }

        });

    }

    //Create on click for button

    /**
     *    public void onHelloBtnClicked(View view){
     *         TextView txtWelcome = findViewById(R.id.txtWelcome);
     *         txtWelcome.setText("Hello this worked");
     *     }
     *
     */

}