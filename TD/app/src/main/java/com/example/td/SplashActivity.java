package com.example.td;

import static com.example.td.LoginActivity.fileN;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    Handler handler;
    public final String  fileN="Mylogindata";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        SharedPreferences sp=getApplicationContext().getSharedPreferences(fileN, Context.MODE_PRIVATE);



        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sp.contains("Usernamekey")&&sp.contains("passwordkey")) {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
                    finish();
                }
            }
        },4000);



    }
}
