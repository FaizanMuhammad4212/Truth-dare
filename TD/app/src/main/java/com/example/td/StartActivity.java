package com.example.td;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.app.Fragment;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.Random;

public class StartActivity extends AppCompatActivity {

    Button btn,chsbtn;
    ImageView imgView;
    Random random = new Random();
    int lastDirection;
    MediaPlayer mp;
    private Fragment fragment;
    ImageButton musicon,musicoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btn = findViewById(R.id.button);
        imgView = findViewById(R.id.imageView);
        chsbtn=findViewById(R.id.textviewbtn);
        musicon=findViewById(R.id.sndbtn22);
        musicoff=findViewById(R.id.sndbtn23);

        musicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(StartActivity.this,NewService.class));
            }
        });
        musicoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(StartActivity.this,NewService.class));
            }
        });

        chsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction().add(R.id.frameLayout,new firstFragment()).addToBackStack(null).commit();

            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        chsbtn.setEnabled(false);
        btn.setEnabled(true);
    }

    public void spin(View view) {

        int newDirection = random.nextInt(5400);
        float pivotX = imgView.getWidth()/2;
        float pivotY = imgView.getHeight()/2;

        Animation rotate = new RotateAnimation(lastDirection, newDirection, pivotX, pivotY);
        rotate.setDuration(5000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                mp = MediaPlayer.create(StartActivity.this, R.raw.audio);
                mp.start();
                btn.setEnabled(false);
                stopService(new Intent(StartActivity.this,NewService.class));
                startService(new Intent(StartActivity.this, instructionService.class));
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mp.stop();
                mp.release();
                mp = null;
                chsbtn.setEnabled(true);
                    startService(new Intent(StartActivity.this, NewService.class));
                stopService(new Intent(StartActivity.this,instructionService.class));

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        lastDirection = newDirection;
        imgView.startAnimation(rotate);
    }

}
