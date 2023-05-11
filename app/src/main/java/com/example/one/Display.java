package com.example.one;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Display extends MainActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent i = getIntent();

        //background color intent
        int color = getIntent().getIntExtra("color", Color.WHITE);
        View vl = findViewById(android.R.id.content);
        vl.setBackgroundColor(color);

        //Gender
        String gender = i.getStringExtra("gender");
        TextView custGender = findViewById(R.id.custGender);
        custGender.setText("The customer is "+ gender);

        //Total amount and item list
        TextView totalAmt = findViewById(R.id.totalAmount);


        String total = i.getStringExtra("totalAmt");

        totalAmt.setText("Total Amount: Rs " + total);

        ListView lv = findViewById(R.id.listView);
        ArrayList<String> items =  getIntent().getStringArrayListExtra("selectedItems");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        lv.setAdapter(adapter);



    }
}
