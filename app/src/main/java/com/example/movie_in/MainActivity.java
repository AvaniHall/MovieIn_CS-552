package com.example.movie_in;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText edit1, edit2;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText)findViewById(R.id.signUpEmail);
        String email =  edit1.getText().toString();
        edit2 = (EditText)findViewById(R.id.signInPassword);
        String pwd =  edit2.getText().toString();

        db = new Database(this);

        Button signIn = findViewById(R.id.button);
        Button signUp = findViewById(R.id.button2);

        signIn.setOnClickListener(v -> {
            if(edit1.getText().toString().trim().length() == 0){
                Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            }else if(edit2.getText().toString().trim().length() == 0){
                Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            }else{
                Boolean checkingEmail = db.checkEmail(email);
                Boolean checkingPassword = db.checkPwd(pwd);
                if(checkingEmail == true && checkingPassword == true) {
                    Intent intent = new Intent(MainActivity.this, MainMenu.class);
                    startActivity(intent);
                }
            }

        });

        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignUp.class);
            startActivity(intent);
        });
    }
}