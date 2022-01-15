package com.example.traindash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class FourActivity extends AppCompatActivity {

    String name, phone, train, seat, card, cvv, date = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        TextView textView = findViewById(R.id.cost);
        TextView textView2 = findViewById(R.id.order);
        TextView textView3 = findViewById(R.id.total);
        TextView textView4 = findViewById(R.id.customer);
        ArrayList<Double> costList = (ArrayList<Double>) getIntent().getSerializableExtra("costList");
        ArrayList<String> orderList = (ArrayList<String>) getIntent().getSerializableExtra("orderList");
        name = (String) getIntent().getSerializableExtra("name");
        phone = (String) getIntent().getSerializableExtra("num");
        train = (String) getIntent().getSerializableExtra("train");
        seat = (String) getIntent().getSerializableExtra("seat");



        //printing out the arrays
        String costs = "";
        for (Double s : costList) {
            costs += "$" + s;
            costs += "\n";
        }
        textView.setText(costs);

        //printing out the arrays
        String order = "";
        for (String s : orderList) {
            order += s + "......................";
            order += "\n";
        }
        textView2.setText(order);

        //prints the total price.
        String total = "";
        Double num = 0.0;
        for (Double r : costList) {
            num += r;
        }
        total += "Total cost: $" + num;
        textView3.setText(total);

        //print out the users info to make sure it is correct
        String info = "";
        info += "Name: " + name + " || Phone Number: " + phone;
        info += "\n";
        info += "Cart: " + train + "|| Seats: " + seat;
        info += "\n";
        textView4.setText(info);


        Button next = findViewById(R.id.next_button);

        next.setOnClickListener(v -> {
            Intent intent = new Intent(FourActivity.this, MainActivity.class);
            startActivity(intent);
        });


    }
}
