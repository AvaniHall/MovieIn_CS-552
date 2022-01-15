package com.example.traindash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    String name, phone, train, seat = "";

    EditText edit1, edit2, edit3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        TextView textView = findViewById(R.id.cost);
        TextView textView2 = findViewById(R.id.order);
        TextView textView3 = findViewById(R.id.total);
        TextView textView4 = findViewById(R.id.customer);
        ArrayList<Double> costList = (ArrayList<Double>) getIntent().getSerializableExtra("cost");
        ArrayList<String> orderList = (ArrayList<String>) getIntent().getSerializableExtra("order");
        name = (String) getIntent().getSerializableExtra("name");
        phone = (String) getIntent().getSerializableExtra("num");
        train = (String) getIntent().getSerializableExtra("train");
        seat = (String) getIntent().getSerializableExtra("seat");

        //credit card info stored
        edit1 = (EditText)findViewById(R.id.editText1);
        String card =  edit1.getText().toString();
        edit2 = (EditText)findViewById(R.id.editText2);
        String cvv =  edit2.getText().toString();
        edit3 = (EditText)findViewById(R.id.editText3);
        String date =  edit3.getText().toString();


        //printing out the arrays
        String costs = "";
        for (Double s : costList) {
            costs += "$" + s;
            costs  += "\n";
        }
        textView.setText(costs);

        //printing out the arrays
        String order = "";
        for (String s : orderList) {
            order += s + "......................";
            order  += "\n";
        }
        textView2.setText(order);

        //prints the total price.
        String total = "";
        Double num = 0.0;
        for(Double r : costList){
            num += r;
        }
        total += "Total cost: $" + num;
        textView3.setText(total);

        //print out the users info to make sure it is correct
        String info = "";
        info += "Name: " + name +  " || Phone Number: " + phone;
        info += "\n";
        info += "Cart: " + train +  "|| Seats: " + seat;
        info += "\n";
        textView4.setText(info);

        //prev button
        Button prev = findViewById(R.id.prev_button);

        prev.setOnClickListener(v -> {
            Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("num", phone);
            intent.putExtra("train", train);
            intent.putExtra("seat", seat);
            startActivity(intent);
        });

        Button next = findViewById(R.id.next_button);

        next.setOnClickListener(v -> {
            if(edit1.getText().toString().trim().length() == 0) {
                Toast.makeText(ThirdActivity.this,
                        "Please enter a card num!",
                        Toast.LENGTH_SHORT).show();
            }else if(edit2.getText().toString().trim().length() == 0) {
                Toast.makeText(ThirdActivity.this,
                        "Please enter a card cvv!",
                        Toast.LENGTH_SHORT).show();
            }else if(edit3.getText().toString().trim().length() == 0)  {
                Toast.makeText(ThirdActivity.this,
                        "Please enter a card date!",
                        Toast.LENGTH_SHORT).show();
            }else {
                Intent intent = new Intent(ThirdActivity.this, FourActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("num", phone);
                intent.putExtra("train", train);
                intent.putExtra("seat", seat);
                intent.putExtra("costList", costList);
                intent.putExtra("orderList", orderList);
                startActivity(intent);
            }
        });
    }

}
