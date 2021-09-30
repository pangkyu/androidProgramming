/*

 입력받은 값을 버튼눌러서 화면에 출력해주는 프로그램
 
 */

package kr.ac.hs.and2021.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button btn;
    TextView tview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //JAVA코드 작성
        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
        //(XML) android:layout_width = "match_parent", android:layout_height = "match_parent"

        LinearLayout baseLayout = new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        //(XML) : android:orientation = "vertical"
       // baseLayout.setBackgroundColor(Color.rgb(0,255,0));
        //(XML) : android:background = "#00ff00"
        setContentView(baseLayout, params);

/*        //예제 1

        Button btn = new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.MAGENTA);
        baseLayout.addView(btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "코드로 생성한 버튼입니다.", Toast.LENGTH_SHORT).show();
            }
        });*/


        // 5-3
        edt = new EditText(this);
        edt.setHint("여기에 입력하세요");
        baseLayout.addView(edt);

        btn = new Button(this);
        btn.setText("버튼입니다.");
        btn.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn);

        tview = new TextView(this);
        tview.setText("텍스트뷰입니다");
        tview.setTextSize(20);
        tview.setTextColor(Color.MAGENTA);
        baseLayout.addView(tview);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                tview.setText(edt.getText().toString());
            }
        });
    }
}