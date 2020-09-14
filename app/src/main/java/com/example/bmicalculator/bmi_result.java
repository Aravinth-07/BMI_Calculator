package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class bmi_result extends AppCompatActivity {
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        t1=(TextView)findViewById(R.id.bmi_value);
        t2=(TextView)findViewById(R.id.bmi_result);
        Bundle b =getIntent().getExtras();
        String Height=b.getString("height");
        String Weight=b.getString("weight");
        double height=Double.parseDouble(Height);
        double weight=Double.parseDouble(Weight);
        double h1=height/100;
        double H1=Math.pow(h1,2);
        double result1=(weight/H1);
        String result2=String.format("%.2f",result1);
        double result=Double.parseDouble(result2);

        if(result<=18.5)
        {
            t1.setText("Your BMI is "+result+" ");
            t2.setText("Result : Underweight");
        }
        else if(result>18.5&&result<=24.9)
        {
            t1.setText("Your BMI is "+result+" ");
            t2.setText("Result : Normal weight");
        }
        else if(result>24.9&&result<29.9)
        {
            t1.setText("Your BMI is "+result+" ");
            t2.setText("Result : Overweight");
        }
        else if(result>=29.9)
        {
            t1.setText("Your BMI is "+result+" ");
            t2.setText("Result : Obese");
        }
    }

    public void btnnext(View view) {
        Intent i=new Intent(this,bmi_calculator.class);
        startActivity(i);
    }
}