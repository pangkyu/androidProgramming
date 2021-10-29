package kr.ac.hs.and2021.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvName, tvEmail;
    Button button2;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("사용자 정보 입력");
        tvName = (TextView)findViewById(R.id.tvName);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
        button2 = (Button) findViewById(R.id.button2);

        final Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);

                AlertDialog.Builder dlg2 = new AlertDialog.Builder(MainActivity.this);
                dlg2.setTitle("사용자 정보 입력");
                dlg2.setIcon(R.drawable.ic_menu_allfriends);
                dlg2.setView(dialogView);
                dlg2.setPositiveButton("확인", null);
                dlg2.setNegativeButton("확인", null);
                dlg2.show();

                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                final String[] versionArray = new String[]{"파이", "큐(10)", "알(11)"};
                final boolean[] checkArray = new boolean[] {true, false, false};
                dlg.setTitle("좋아하는 버전은?");
                dlg.setIcon(R.mipmap.ic_launcher);

                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i, boolean isChecked) {
                        button1.setText(versionArray[i]); // 여기서는 마지막에 선택된 항목이 setText처리 된다.
                    }
                });


                /*
                dlg.setSingleChoiceItems(versionArray, 0,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        button1.setText(versionArray[i]); // 버튼의 텍스트가 변경
                    }
                });*/
                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });
    }
}