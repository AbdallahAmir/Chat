package com.example.amir.chat;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {
    EditText uName;
    TextView text1;
    String Name;
    SharedPreferences settings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        settings = getSharedPreferences("NAME", 0);
        Boolean check = settings.getBoolean("check", false);


        uName = (EditText) findViewById(R.id.user);
        text1 = (TextView) findViewById(R.id.text1);


        if (check) {
            Intent i = new Intent(Login.this,MainActivity.class);
            startActivity(i);
            finish();
        }

    }

    public void onClick(View v) {

        Name = uName.getText().toString();

        if(Name.isEmpty() || Name.trim().length() < 3){
            text1.setText("Plz Enter Name");
        }else {
            settings = getSharedPreferences("NAME", 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean("check", true);
            editor.putString("name", Name);
            editor.apply();
            Intent i1 = new Intent(Login.this,MainActivity.class);
            startActivity(i1);
            finish();
        }

    }
}