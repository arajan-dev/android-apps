package com.aravind.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    int ranNum;
    Random ranG = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);

    }

    public void checkGuess(View view) {
        String userInput = editText.getText().toString();
        if (userInput.isEmpty()) {
            editText.setText("Type a number");
        } else {
            int userNum = Integer.valueOf(editText.getText().toString());
            if (ranNum < userNum) {
                editText.setText("Too large");
            } else if (ranNum > userNum) {
                editText.setText("Too small");
            } else {
                editText.setText("Bingo!!Try again");
                Toast.makeText(getApplicationContext(), "Game reset",Toast.LENGTH_LONG).show();
                generateNumber();
            }
        }
    }
    public void generateNumber() {
        ranNum = ranG.nextInt(100);
    }
}
