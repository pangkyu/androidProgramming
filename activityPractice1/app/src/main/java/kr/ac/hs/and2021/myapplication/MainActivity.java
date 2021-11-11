package kr.ac.hs.and2021.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 엑티비티");

        Button rdoSecond = findViewById(R.id.rdoSecond);
        Button rdoThird = findViewById(R.id.rdoThird);
        Button btnNewActivity = findViewById(R.id.btnNewActivity);
        Button rdoRating = findViewById(R.id.rdoRating);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rdoSecond.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent;
                        intent = new Intent(getApplicationContext(), SecondActivity.class);
                        startActivity(intent);
                    }
                });
                rdoThird.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent;
                        intent = new Intent(getApplicationContext(), ThirdActivity.class);
                        startActivity(intent);
                    }
                });

                rdoRating.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent;
                        intent = new Intent(getApplicationContext(), RatingBarActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
}