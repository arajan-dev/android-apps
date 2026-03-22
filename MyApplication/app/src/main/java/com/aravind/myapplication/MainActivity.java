package com.aravind.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PatientAccount newPatient = new PatientAccount("Alice", 200);

        PatientAccount newPatient2 = new PatientAccount();
        System.out.println(newPatient2.getName());
        System.out.println("Balance:" + newPatient.getBalance());
    }
}
