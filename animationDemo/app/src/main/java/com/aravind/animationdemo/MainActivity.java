package com.aravind.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //translation
                //button.animate().translationXBy(200).setDuration(1000);
                //rotation
                //button.animate().rotation(3600).setDuration(1000);
                //button.animate().alpha(0).setDuration(1000);
                //button.animate().scaleX(2).scaleY(2).setDuration(2000);
            }
        });
    }
}
