package kr.ac.hs.and2021.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("액티비티 테스트 예제 ");
        android.util.Log.i("액티비티 테스트", "onCreate()");

        Button btnDial = (Button) findViewById(R.id.btnDial);
        btnDial.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel : 010-1234-7899");
            Intent intent = new Intent(Intent.ACTION_DIAL, uri);
            startActivity(intent);
        });
        Button btnFinish = (Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(v -> finish());
    }

    @Override
    public void onResume(){
        super.onResume();
        android.util.Log.i("액티비티 테스트", "onResume()");
    }
    @Override
    public void onStart(){
        super.onStart();
        android.util.Log.i("액티비티 테스트", "onStart()");
    }
    @Override
    public void onRestart(){
        super.onRestart();
        android.util.Log.i("액티비티 테스트", "onRestart()");
    }
    @Override
    public void onPause(){
        super.onPause();
        android.util.Log.i("액티비티 테스트", "onPause()");
    }
}