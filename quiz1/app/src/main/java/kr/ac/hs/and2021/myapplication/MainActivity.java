package kr.ac.hs.and2021.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout baseLayout = new LinearLayout(this);
        LinearLayout.LayoutParams btn = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        baseLayout.setBackgroundColor(Color.GREEN);
        setContentView(baseLayout, params);


        //BUTTON 생성
        Button button1 = new Button(this);

        button1.setText("배성규(201758101");
        button1.setLayoutParams(btn);

        Button button2 = new Button(this);
        button2.setText("숨김 버튼");
        button2.setLayoutParams(btn);
        button2.setVisibility(View.INVISIBLE);


        Button button3 = new Button(this);
        button3.setText("파란색 글씨 텍스트뷰");
        button3.setLayoutParams(btn);
        button3.setTextColor(Color.BLUE);


    }
}