package com.example.td;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class instructionService extends Service {

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        Toast.makeText(this, "Wait for bottle to stop", Toast.LENGTH_LONG).show();

        return START_STICKY;
    }

    @Override
    public void onDestroy(){

        Toast.makeText(this, "NOw click Oval shape multicolor button ", Toast.LENGTH_LONG).show();

    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
