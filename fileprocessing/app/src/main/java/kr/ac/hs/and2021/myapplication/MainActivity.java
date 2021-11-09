package kr.ac.hs.and2021.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단 일기장");
        dp = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnWrite = findViewById(R.id.btnWrite);
        Calendar cal = Calendar.getInstance();
        int cYear = cal.get(Calendar.YEAR);
        int cMonth = cal.get(Calendar.MONTH);
        int cDay = cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                fileName = Integer.toString(year) + "_"
                        + Integer.toString(monthOfYear + 1) + "_"
                        + Integer.toString(dayOfMonth) + ".txt";
                String str = readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    FileOutputStream outFs = openFileOutput(fileName, MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName + "이 저장 생성됨", Toast.LENGTH_SHORT).show();
                }catch (IOException e){

                }
            }
        });
    }



    //file명의 파일을 읽어와서 그 내용을 반환하는 메소드
   String readDiary(String fileName){
       FileInputStream inFs;
       String diaryStr = null;
       try{
           inFs = openFileInput(fileName);
           byte[] txt = new byte[500];
           inFs.read(txt);
           inFs.close();
           diaryStr = (new String(txt)).trim(); // trim ==> 빈 여백을 다 제거할 수 있다
           btnWrite.setText("수정 하기");
       }catch (IOException e ){
            edtDiary.setHint("일기가 없다");
            btnWrite.setText("새로 저장");
       }
       return diaryStr; // 파일이 없는 경우 catch로 빠지고 파일이 있으면 얻은 스트링을 diaryStr로 리턴
    }
}