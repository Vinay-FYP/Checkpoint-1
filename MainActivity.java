package com.example.ui_tutorial3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private CheckBox checkboxHarry, checkBoxMatrix, checkBoxJoker;
    private RadioGroup MarriageStatus;
    private ProgressBar pbar;
    private TextView percentage ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkboxHarry = findViewById(R.id.checkboxHarry);
        checkBoxJoker = findViewById(R.id.checkboxJoker);
        checkBoxMatrix = findViewById(R.id.checkboxMatrix);

        MarriageStatus = findViewById(R.id.MarriageStatus);
        percentage = findViewById(R.id.percentage);

        pbar = findViewById(R.id.progressBar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0; i<10; i++){
                    pbar.incrementProgressBy(10);
                    percentage.setText(pbar.getProgress());
                    SystemClock.sleep(500);
                }
            }
        });
        thread.start();



        int CheckedBtn = MarriageStatus.getCheckedRadioButtonId();
        switch(CheckedBtn){
            case R.id.rbMarried:
                Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbSingle:
                Toast.makeText(MainActivity.this,"Single",Toast.LENGTH_LONG).show();
                break;
            case R.id.inRel:
                Toast.makeText(MainActivity.this,"In relationshop", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

        MarriageStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rbMarried:
                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.rbSingle:
                        Toast.makeText(MainActivity.this,"Single",Toast.LENGTH_LONG).show();

                        break;
                    case R.id.inRel:
                        Toast.makeText(MainActivity.this,"In relationshop", Toast.LENGTH_LONG).show();

                        break;
                    default:
                        break;
                }
            }
        });

        if(checkboxHarry.isChecked()){
            Toast.makeText(MainActivity.this,"Already watched HP",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this,"Already watched HP",Toast.LENGTH_LONG).show();
        }

        checkboxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "You have watched Harry Potter", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "You need to watch Harry Potter", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}