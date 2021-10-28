package kr.ac.hs.and2021.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRead, btnWrite;
        btnRead = findViewById(R.id.btnRead);
        btnWrite = findViewById(R.id.btnWrite);

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream outFs = openFileOutput("file.txt", Context.MODE_PRIVATE); // calling application
                    String str = "안드로이드a반 화이팅";
                    outFs.write(str.getBytes(str));
                    outFs.close();
                    Toast.makeText(getApplicationContext(),"file.txt가 생성되었습니다.", Toast.LENGTH_SHORT).show();
                }catch(IOException e){

                }
            }
        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileInputStream inFs = openFileInput("file.txt" );
                    byte[] txt = new byte[30];
                    inFs.read(txt);
                    String str = new String(txt);
                    Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    inFs.close();
                }catch(IOException e){
                    Toast.makeText(getApplicationContext(),"파일이 없음", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}