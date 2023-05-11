package com.example.one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.RadialGradient;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button display = findViewById(R.id.button);
        CheckBox cb1 = findViewById(R.id.checkBox);
        CheckBox cb2 = findViewById(R.id.checkBox2);
        CheckBox cb3 = findViewById(R.id.checkBox3);
        Spinner sp = findViewById(R.id.spinner);
        RadioGroup rg = findViewById(R.id.radioGroup);

        List<String> mList = Arrays.asList("Male", "Female", "Others");

        ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, mList);
        mArrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        // Set the adapter to the Spinner
        sp.setAdapter(mArrayAdapter);

        //Selected Item for spinner


        //Display button
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checkBox
                int total = 0;
                ArrayList<String> selectedItems = new ArrayList<>();
                if (cb1.isChecked()) {
                    total += 200;
                    selectedItems.add("Peanuts");

                }
                if (cb2.isChecked()) {
                    total += 150;
                    selectedItems.add("Breads");

                }
                if (cb3.isChecked()) {
                    total += 100;
                    selectedItems.add("Fruits");

                } else {
                    Toast.makeText(MainActivity.this, "Nothing is selected", Toast.LENGTH_SHORT).show();
                }

                //Toast.makeText(MainActivity.this, "Total amount is" + total, Toast.LENGTH_SHORT).show();

                //Radio Button
                int selectedColor = Color.WHITE;
                switch (rg.getCheckedRadioButtonId()) {
                    case R.id.radioButton1:
                        selectedColor = Color.CYAN;
                        break;

                    case R.id.radioButton2:
                        selectedColor = Color.RED;
                        break;

                    case R.id.radioButton3:
                        selectedColor = Color.YELLOW;
                        break;
                }

                //spinner
                String gender = sp.getSelectedItem().toString();


                //Intent
                String totalAmt = Integer.toString(total);
                Intent i = new Intent(MainActivity.this, Display.class);
                i.putExtra("color", selectedColor);
                i.putExtra("totalAmt", totalAmt);
                i.putExtra("gender", gender);
                i.putStringArrayListExtra("selectedItems", selectedItems);
                startActivity(i);

                //Background of the main activity
                View rl = findViewById(android.R.id.content);
                rl.setBackgroundColor(Color.GREEN);

                //Change Background of display activity using radio buttons


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutUs:
                Intent myIntent = new Intent(MainActivity.this, AboutUs.class);
                MainActivity.this.startActivity(myIntent);
                return true;
        }
        return (super.onOptionsItemSelected(item));
    }


}