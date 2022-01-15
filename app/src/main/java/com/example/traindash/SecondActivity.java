package com.example.traindash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    //keep track order, and cost
    ArrayList<String> order = new ArrayList<>();
    ArrayList<Double> cost = new ArrayList<>();

    //info
    String name, phone, train, seat = "";


    //variables
    CheckBox b1, b2, b3, b4, b5, b6, b7, b8, b9;

    int a, b, c, d, e, f, g, h, j = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        order.clear();
        cost.clear();

        //variables
        name = (String) getIntent().getSerializableExtra("name");
        phone = (String) getIntent().getSerializableExtra("num");
        train = (String) getIntent().getSerializableExtra("train");
        seat = (String) getIntent().getSerializableExtra("seat");

        //variables for the buttons
        Button prev = findViewById(R.id.prev_button);
        Button next = findViewById(R.id.next_button);

        //check box variables
        b1 = findViewById(R.id.checkBox1);
        b2 = findViewById(R.id.checkBox2);
        b3 = findViewById(R.id.checkBox3);
        b4 = findViewById(R.id.checkBox4);
        b5 = findViewById(R.id.checkBox5);
        b6 = findViewById(R.id.checkBox6);
        b7 = findViewById(R.id.checkBox7);
        b8 = findViewById(R.id.checkBox8);
        b9 = findViewById(R.id.checkBox9);


        //the result of when the user taps on the buttons
        prev.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(intent);
        });

        next.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtra("cost", cost);
            intent.putExtra("order", order);
            intent.putExtra("name", name);
            intent.putExtra("num", phone);
            intent.putExtra("train", train);
            intent.putExtra("seat", seat);
            startActivity(intent);
        });


    }

    public void onClick(View view) {
        if(b1.isChecked() && a==0){
            cost.add(8.00);
            order.add("Hamburger");
            a=1;
        }
        if(b2.isChecked() && b==0){
            cost.add(6.00);
            order.add("Salad");
            b=1;
        }
        if(b3.isChecked() && c==0){
            cost.add(9.00);
            order.add("Steak");
            c=1;
        }
        if(b4.isChecked() && d==0){
            cost.add(1.00);
            order.add("Fries");
            d=1;
        }
        if(b5.isChecked() && e==0){
            cost.add(0.95);
            order.add("Chips");
            e=1;
        }
        if(b6.isChecked() && f==0){
            cost.add(1.00);
            order.add("Sprouts");
            f=1;
        }
        if(b7.isChecked() && g==0){
            cost.add(1.25);
            order.add("Soda");
            g=1;
        }
        if(b8.isChecked() && h==0){
            cost.add(0.50);
            order.add("Water");
            h=1;
        }
        if(b9.isChecked() && j==0){
            cost.add(2.00);
            order.add("Coffee");
            j=1;
        }
    }
}
