package com.example.td;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText name,paswrd,cpaswrd;
    Button signup,signin;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.uname);
        paswrd=findViewById(R.id.pswrd1);
        cpaswrd=findViewById(R.id.pswrd2);
        signup=findViewById(R.id.btnsup);
        signin=findViewById(R.id.btnsin);

        db=new DBHelper(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=name.getText().toString();
                String pswd=paswrd.getText().toString();
                String cpswd=cpaswrd.getText().toString();

                if(user.equals("")||pswd.equals("")||cpswd.equals("")){
                    Toast.makeText(RegisterActivity.this, "Fields can't be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(pswd.equals(cpswd)){
                        Boolean checkuser=db.checkusername(user);
                        if(checkuser==false){
                            Boolean insert=db.insertData(user,pswd);
                              if(insert==true){
                                  Toast.makeText(RegisterActivity.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                                  Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                                  startActivity(intent);
                              }
                              else{
                                  Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                              }
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "User Already exists plz sign in or change username", Toast.LENGTH_SHORT).show();
                        }

                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Both Passwords shold be same", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });

    }
}