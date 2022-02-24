package com.example.td;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class NewService extends Service {
    MediaPlayer mp;


    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        mp=MediaPlayer.create(this,R.raw.squid);
        mp.setLooping(true);
        mp.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mp.stop();
        mp.release();
        mp=null;
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
