package com.cookandroid.project8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
public class MainActivity extends AppCompatActivity {
    Button btnPrev,btnNext;
    myPictureView myPicture;
    int curNum;
    File[] imageFiles;
    String imageFname;
    TextView textView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("간단 이미지뷰어");
        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        btnPrev=(Button)findViewById(R.id.btnPrev);
        btnNext=(Button)findViewById(R.id.btnNext);
        textView1=(TextView)findViewById(R.id.textview1);
        myPicture=(myPictureView) findViewById(R.id.myPictureView1);
        imageFiles= new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();
        imageFname=imageFiles[1].toString();
        myPicture.imagePath=imageFname;
        btnPrev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(curNum<=1){
                    curNum = imageFiles.length -1;
                }
                else{
                    curNum--;
                }
                int buff = curNum + 1;
                textView1.setText(Integer.toString(buff));
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (curNum >= imageFiles.length - 1) {
                    curNum = 1;
                } else {
                    curNum++;
                }
                int buff = curNum + 1;
                textView1.setText(Integer.toString(buff));
                imageFname = imageFiles[curNum].toString();
                myPicture.imagePath = imageFname;
                myPicture.invalidate();
            }
        });

    }
}