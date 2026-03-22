package com.aravind.patientaccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText inputName, inputHis, inputAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        inputName = findViewById(R.id.editText);
        inputHis = findViewById(R.id.editText2);
        inputAge = findViewById(R.id.editText3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                String history = inputHis.getText().toString();
                int age = Integer.parseInt(inputAge.getText().toString());

                //constructor
                PatientAccount newPatient = new PatientAccount(name, history, age);

                //pass object to new activity

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("newPatient",newPatient);

                //important
                startActivity(intent);
            }
        });
    }
}
