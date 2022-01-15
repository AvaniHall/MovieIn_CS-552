package com.example.traindash

import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.content.Intent
import android.widget.EditText






class MainActivity : AppCompatActivity(), OnItemSelectedListener {

    //variables for the spinners
    private var carts = arrayOf<String?>("Train Cart A", "Train Cart B", "Train Cart C")
    private var seats = arrayOf<String?>("1-3", "3-6", "6-9")
    var selectTrain = ""
    var seat = ""


    //next button
    private lateinit var next: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //name, and phone number
        val user = findViewById<View>(R.id.name) as EditText
        val num = findViewById<View>(R.id.phoneNum) as EditText

        //button
        next = findViewById(R.id.first_activity_button)


        //This is for the first spinner to find the train cart
        val spin1 = findViewById<Spinner>(R.id.cart_list)
        spin1.onItemSelectedListener = this
        val ad1: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, carts)
        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin1.adapter = ad1


        //This is for the second spinner to find the seat
        val spin2 = findViewById<Spinner>(R.id.seat_list)
        spin2.onItemSelectedListener = this
        val ad2: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, seats)
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spin2.adapter = ad2



        //button for the next activity
        next.setOnClickListener{
            val name: String = user.text.toString()
            val phone: String = num.text.toString()
            if(name.isEmpty()) {
                user.error = "Please Enter a username!"
            }else if (phone.isEmpty()){
                num.error = "Please Enter a phone number!"
            }else {
                intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("num", phone)
                intent.putExtra("train", selectTrain)
                intent.putExtra("seat", seat)
                startActivity(intent)
            }
        }
    }


    //this will store the answers that the user selected when using the spinner wheel
    override fun onItemSelected(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        selectTrain = carts[position].toString()
        seat = seats[position].toString()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}
