package kr.ac.hs.and2021.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listViewMP3;
    Button btnPlay, btnStop, btn;
    TextView tvMP3;
    ProgressBar pbMP3, pb1, pb2;


    ArrayList<String> mp3List;
    String selectedMP3;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/";
    MediaPlayer mPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher_background);
        setTitle("간단한 mp3 플레이어");
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        final MediaPlayer nPlayer;
        nPlayer = MediaPlayer.create(this, R.raw.after);

        //SDCARD의 파일을 읽어서 리스트뷰에 출력
        mp3List = new ArrayList<String>(); // 가변적 문자열

        File[] listFiles = new File(mp3Path).listFiles();
        String fileName, extName;
        for ( File file : listFiles){
            fileName = file.getName();
            extName = fileName.substring(fileName.length() - 3 );
            if(extName.equals((String) "mp3")) // 확장명이 mp3일때
                mp3List.add(fileName);
        }

        ListView listViewMP3 = (ListView) findViewById(R.id.listViewMP3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, mp3List);
        listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listViewMP3.setAdapter(adapter);
        listViewMP3.setItemChecked(0, true);
        listViewMP3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int arg2, long arg3) {
                selectedMP3 = mp3List.get(arg2);
            }
        });
        selectedMP3 = mp3List.get(0);

        pb1 = (ProgressBar)findViewById(R.id.pb1);
        pb2 = (ProgressBar)findViewById(R.id.pb2);
        btn = (Button) findViewById(R.id.button1);


        new Thread(){
            public void run(){
                for(int i = pb1.getProgress(); i<100; i+=2){
                    pb1.setProgress(pb1.getProgress()+2);
                    SystemClock.sleep(100);
                }
            }
        }.start();

        new Thread(){
            public void run(){
                for(int i = pb2.getProgress(); i<100; i++){
                    pb2.setProgress(pb2.getProgress()+1);
                    SystemClock.sleep(100);
                }
            }
        }.start();

        new Thread(){
            SimpleDateFormat timeFormat = new SimpleDateFormat("mm:ss");
            public void run(){
                if(mPlayer == null) return;
                pbMP3.setMax(mPlayer.getDuration());
                while(mPlayer.isPlaying()){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pbMP3.setProgress(mPlayer.getCurrentPosition());
                            tvTime.setText("진행 시간 : " + timeFormat.format(mPlayer.getCurrentPosition()))
                        }
                    });
                    SystemClock.sleep(200);
                }
            }
        }.start();

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnStop = (Button) findViewById(R.id.btnStop);
        listViewMP3 = (ListView) findViewById(R.id.listViewMP3);
        tvMP3 = (TextView)findViewById(R.id.tvMP3);
        pbMP3 = (ProgressBar)findViewById(R.id.pbMP3);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    mPlayer = new MediaPlayer();
                    mPlayer.setDataSource(mp3Path + selectedMP3);
                    mPlayer.prepare();
                    mPlayer.start();
                    btnPlay.setClickable(false);
                    btnStop.setClickable(true);
                    tvMP3.setText("실행중인 음악 : " + selectedMP3);
                    pbMP3.setVisibility(View.VISIBLE);
                }catch (IOException e){

                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
                mPlayer.reset();
                btnPlay.setClickable(true);
                btnStop.setClickable(false);
                tvMP3.setText("실행중인 음익 : ");
                pbMP3.setVisibility(View.INVISIBLE);
            }
        });
        btnStop.setClickable(false);


/*
* 일시정지추가
* btnPause.setOnClickListener(new View.OnClickListener(){
*  public void onClick(View v){
*   if(PAUSED == false){
*       mPlayer.pause();
*       btnPause.setText("이어듣기");
*       PAUSED = true;
*       pbMP3.setVisibility(View.INVISIBLE);
*   }else{
*       mPlayer.start();
*       PAUSED = false;
*       btnPause.setText("일시정지");
*       pbMP3.setVisibility(View.VISIBLE);
*
*   }
*  }
* });
* btnPause.seetClickable(false);
* */





        final Switch switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switch1.isChecked() == true){
                    nPlayer.start();
                }
                else nPlayer.stop();
            }
        });
    }
}