package com.aravind.bmicalc;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    RadioButton us,si;
    EditText weight,height1,height2,showBMI, bmi;
    TextView weightT,height1T,height2T;
    Button calcBMI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        us = findViewById(R.id.radioButton3);
        si = findViewById(R.id.radioButton4);
        weight = findViewById(R.id.editText2);
        height1 = findViewById(R.id.editText3);
        height2 = findViewById(R.id.editText4);
        bmi = findViewById(R.id.editText6);
        weightT = findViewById(R.id.textView2);
        height1T = findViewById(R.id.textView3);
        height2T = findViewById(R.id.textView4);
        calcBMI = findViewById(R.id.button);
        showBMI = findViewById(R.id.editText5);

        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightT.setText("WEIGHT (lb):");
                weight.setHint("Enter weight in pounds");
                height1T.setText("HEIGHT (ft):");
                height1.setHint("Enter feet");
                height2T.setVisibility(View.VISIBLE);
                height2.setVisibility(View.VISIBLE);
                height2.setHint("Enter inches");
            }
        });

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightT.setText("WEIGHT (Kg):");
                weight.setHint("Enter weight in kg");
                height1T.setText("HEIGHT (cm):");
                height1.setHint("Enter height in cm");
                height2T.setVisibility(View.INVISIBLE);
                height2.setVisibility(View.INVISIBLE);
            }
        });

        calcBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean usflag = us.isChecked();
                boolean siflag = si.isChecked();
                boolean valuesFlag = false;
                double bmiValue = 0;
                if(usflag) {
                    if(weight.getText().toString().isEmpty() || height1.getText().toString().isEmpty() || height2.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(),"One or more values missing!",Toast.LENGTH_LONG).show();
                    }
                    else {
                        double weightVal, heightFtVal, heightInVal;
                        weightVal = Double.parseDouble(weight.getText().toString());
                        heightFtVal = Double.parseDouble(height1.getText().toString());
                        heightInVal = Double.parseDouble(height2.getText().toString());
                        bmiValue = calculateBMI(weightVal, heightFtVal, heightInVal);
                        valuesFlag = true;
                    }
                }
                else if(siflag){
                    if (weight.getText().toString().isEmpty() || height1.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(), "One or more values missing!", Toast.LENGTH_LONG).show();
                    } else {
                        double weightKgVal, heightCmVal;
                        weightKgVal = Double.parseDouble(weight.getText().toString());
                        heightCmVal = Double.parseDouble(height1.getText().toString());
                        bmiValue = calculateBMI(weightKgVal, heightCmVal);
                        valuesFlag = true;
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Choose units you want to use!", Toast.LENGTH_LONG).show();
                }
            if(valuesFlag == true) {
                //write bmi in the textbox
                bmi.setText("BMI: " + String.format("%.2f", bmiValue));
                String bmiText;
                if (bmiValue < 18.5) {
                    bmiText = "UNDERWEIGHT";
                    showBMI.setText(bmiText);
                    showBMI.setTextColor(Color.RED);
                } else if (bmiValue > 40) {
                    bmiText = "EXTREME OBESE";
                    showBMI.setText(bmiText);
                    showBMI.setTextColor(Color.RED);
                } else if (bmiValue < 25) {
                    bmiText = "HEALTHY";
                    showBMI.setText(bmiText);
                    showBMI.setTextColor(Color.GREEN);
                } else if (bmiValue < 30) {
                    bmiText = "OVERWEIGHT";
                    showBMI.setText(bmiText);
                    showBMI.setTextColor(Color.DKGRAY);
                } else if (bmiValue < 40) {
                    bmiText = "OBESE";
                    showBMI.setText(bmiText);
                    showBMI.setTextColor(Color.MAGENTA);
                }
            }
            }
        });
    }

    //write different functions

    public double calculateBMI(double weightKgVal,double heightCmVal) {
        //double heightMeters = heightCmVal/100;
        //double heightMeterSquare = Math.pow(heightMeters,2);
        //weight/height in m squared
        return (weightKgVal/(Math.pow((heightCmVal/100),2)));
    }

    public double calculateBMI(double weightVal, double heightFtVal, double heightInVal) {

        //703*weight /height in inches squared
        return (703*(weightVal/(Math.pow(((12*heightFtVal)+heightInVal),2))));
    }
}
