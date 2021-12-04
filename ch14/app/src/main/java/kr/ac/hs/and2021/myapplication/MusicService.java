package kr.ac.hs.and2021.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.MediaStore;


public class MusicService extends Service {
    MediaPlayer mp;
    @Override
    public IBinder onBind(Intent intent) {return null;}

    @Override
    public void onCreate(){
        android.util.Log.i("서비스 테스트", "onCreate()");
        super.onCreate();
    }

    @Override
    public void onDestroy(){
        android.util.Log.i("서비스 테스트", "onDestroy()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        android.util.Log.i("서비스 테스트", "onStartCommand()");
        mp = MediaPlayer.create(this, R.raw.song1);
        mp.setLooping(true);
        mp.start();
        return super.onStartCommand(intent, flags, startId);
    }
}
