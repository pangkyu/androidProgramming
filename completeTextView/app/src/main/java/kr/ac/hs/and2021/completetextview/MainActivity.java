package kr.ac.hs.and2021.completetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
@SuppressWarnings("deprecation") // 이 코드를 넣으면 TabListener 에러줄 사라진다.
public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 자동완성 기능 구현, 멀티 자동완성 기능 구현
        String[] items = {
                "CSI-뉴욕", "CSI-라스베이거스", "CSI-마이애미", "Friends", "Fringe", "LOST"
        };
        AutoCompleteTextView auto = findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, items);
        auto.setAdapter(adapter);

        MultiAutoCompleteTextView multi = findViewById(R.id.multiAutoCompleteTextzView1);
        MultiAutoCompleteTextView.CommaTokenizer token = new MultiAutoCompleteTextView.CommaTokenizer();
        multi.setTokenizer(token);
        multi.setAdapter(adapter);
        // 여기까지


    }
}