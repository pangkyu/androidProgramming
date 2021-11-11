package kr.ac.hs.and2021.myapplication;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class Dialog extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);
    }
}
