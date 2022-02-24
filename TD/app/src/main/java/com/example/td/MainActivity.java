package com.example.td;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button start, truth, dare,logout;
    ImageButton musicon,musicoff;
    private SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public final String  fileN="Mylogindata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=findViewById(R.id.start);
        truth=findViewById(R.id.truth);
        dare=findViewById(R.id.dare);
        logout=findViewById(R.id.logout);
        musicon=findViewById(R.id.sndbtn);
        musicoff=findViewById(R.id.sndbtn2);

        musicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(MainActivity.this,NewService.class));
            }
        });
        musicoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(MainActivity.this,NewService.class));
            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),StartActivity.class));

            }
        });

        truth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),TruthActivity.class));

            }
        });

        dare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DareActivity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences=getSharedPreferences(fileN, Context.MODE_PRIVATE);
                editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();

                startActivity(new Intent(getApplicationContext(),SplashActivity.class));
                finish();
            }
        });
    }


}