package kr.ac.hs.and2021.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        Button btnRead, btnMkdir, btnRmdir, btnFilelist;

        final EditText edtSD,edtFilelist;
        btnRead = (Button) findViewById(R.id.btnRead);
        edtSD = (EditText) findViewById(R.id.edtSD);
        btnMkdir = findViewById(R.id.btnMkdir);
        btnRmdir = findViewById(R.id.btnRmdir);
        btnFilelist = findViewById(R.id.btnFilelist);
        edtFilelist = (EditText)findViewById(R.id.edtFilelist);

        btnFilelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sysDir = Environment.getRootDirectory().getAbsolutePath();
                // File.listFiles()
                File[] sysFiles = (new File(sysDir).listFiles());
                String strFname;
                for (int i = 0; i< sysFiles.length; i++){
                    if(sysFiles[i].isDirectory() == true){
                        strFname = "<폴더>" + sysFiles[i].toString();
                    }else{
                        strFname = "<파일>" + sysFiles[i].toString();
                    }
                    edtFilelist.setText(edtFilelist.getText() + "\n" + strFname);
                }
            }
        });

        final String strSDpath = Environment.getExternalStorageDirectory().getAbsolutePath(); // 절대경로를 얻을 수 있는 구문

        //mydir
        final File myDir = new File(strSDpath + "/mydir");
        btnMkdir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                myDir.mkdir();
            }
        });

        btnRmdir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDir.delete();
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    FileInputStream inFs = new FileInputStream("/storage/emulated/0/file.txt");
                    byte[] txt = new byte[inFs.available()]; // inFs를 담을수있는 만큼 배열공간 생성
                    inFs.read(txt);
                    edtSD.setText(new String(txt));
                    inFs.close();
                }catch (IOException e){

                }
            }
        });
    }
}