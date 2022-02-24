package com.example.td;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText usernm,pswrd;
    Button  signin,signup;
    DBHelper db;
    SharedPreferences sharedPreferences;

    public static final String fileN="Mylogindata";
    public static final String uName="Usernamekey";
    public static final String uPass="passwordkey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernm=findViewById(R.id.uname1);
        pswrd=findViewById(R.id.pswrd11);
        signin=findViewById(R.id.btnsin1);
        signup=findViewById(R.id.btnsup1);

        db=new DBHelper(this);

       sharedPreferences=getSharedPreferences(fileN,Context.MODE_PRIVATE);



        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=usernm.getText().toString();
                String pass=pswrd.getText().toString();



                if(user.equals("")||pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Fields can't be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkusrpass=db.checkusernamepassword(user,pass);
                    if(checkusrpass==true){

                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString(uName,user);
                        editor.putString(uPass,pass);
                        editor.commit();

                        Toast.makeText(LoginActivity.this, "Sign in Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(LoginActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }


}