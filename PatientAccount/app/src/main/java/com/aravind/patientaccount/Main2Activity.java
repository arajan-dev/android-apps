package com.aravind.patientaccount;

import android.print.PrintAttributes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button getName,getHis,getAge;
    PatientAccount patientAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        getName = findViewById(R.id.button2);
        getHis = findViewById(R.id.button3);
        getAge = findViewById(R.id.button4);

        patientAccount = (PatientAccount) getIntent().getSerializableExtra("newPatient");

        //patientAccount = (PatientAccount) getIntent().getSerializableExtra("newPatient");

        getName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = patientAccount.getPatientName();
                getName.setText(name);
            }
        });

        getHis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String his = patientAccount.getHistory();
                getHis.setText(his);
            }
        });

        getAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age = patientAccount.getPatientAge();
                getAge.setText(String.valueOf(age));

            }
        });
    }
}
