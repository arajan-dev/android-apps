package com.aravind.bmicalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText height, weight, bmi;
    double heightNum, weightNum, bmiNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.editText3);
        weight = findViewById(R.id.editText4);
        bmi = findViewById(R.id.editText5);
        System.out.println(convertHeight(50));
    }

    public void calBMI(View view) {
        // 1. take input from the user, convert to double
        heightNum = Double.parseDouble(height.getText().toString());
        weightNum = Double.parseDouble(weight.getText().toString());
        // 2. calculate BMI and show it in the BMI editText element;
        bmiNumber = weightNum / (Math.pow((heightNum/100), 2));
        bmi.setText(String.format("%.2f", bmiNumber));
    }

    public double convertHeight(int inches) {
        return(inches*2.54);
    }
    public double convertHeight(int inches, int feet) {
        return((30.48*feet)+(inches*2.54));
    }
}