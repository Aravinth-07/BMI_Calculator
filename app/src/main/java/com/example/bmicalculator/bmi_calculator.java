package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class bmi_calculator extends AppCompatActivity {
    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         e1=(EditText)findViewById(R.id.et1);
         e2=(EditText)findViewById(R.id.et2);

    }

    public void btnonclick(View view) {
        try {
            String height = e1.getText().toString();
            String weight = e2.getText().toString();
            double height1 = Double.parseDouble(height);
            double weight1 = Double.parseDouble(weight);
            if (height.length() == 0) {
                height1 = 0;
                e1.setError("Height cannot be empty");
            } else if (weight.length() == 0) {
                weight1 = 0;
                e2.setError("Weight cannot be empty");
            } else if (weight.length() != 0 && height.length() != 0) {
                if (height1 <= 30 || height1 >= 300) {
                    e1.setError("Enter correct height value");
                } else if (weight1 >= 1000) {
                    e2.setError("Enter correct weight value");
                } else {
                    Intent i = new Intent(this, bmi_result.class);
                    i.putExtra("height", height);
                    i.putExtra("weight", weight);
                    startActivity(i);
                }
            }
        }
        catch (NumberFormatException e)
        {
            e1.setError("Height cannot be empty");
            e2.setError("Weight cannot be empty");
        }

    }
}