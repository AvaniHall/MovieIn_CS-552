package com.example.movie_in;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity {

    EditText edit1, edit2, edit3;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        edit1 = (EditText)findViewById(R.id.editTextTextPersonName);
        String name =  edit1.getText().toString();
        edit2 = (EditText)findViewById(R.id.editTextTextPersonName2);
        String email =  edit2.getText().toString();
        edit3 = (EditText)findViewById(R.id.editTextTextPassword);
        String pwd =  edit3.getText().toString();

        Button signUP = findViewById(R.id.signUpButton);
        Button back = findViewById(R.id.backButton1);

        db = new Database(this);

        signUP.setOnClickListener(v -> {
            Boolean yes  = db.insertData(name,
                    email,
                    pwd);
            if(yes == true){
                Toast.makeText(SignUp.this, "Got it!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(SignUp.this, "Error!", Toast.LENGTH_SHORT).show();
            }
        });

        back.setOnClickListener(v -> {
            Intent intent = new Intent(SignUp.this, MainActivity.class);
            startActivity(intent);
        });
    }
}
