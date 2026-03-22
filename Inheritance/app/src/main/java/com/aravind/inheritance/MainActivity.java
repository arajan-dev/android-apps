package com.aravind.inheritance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    class Animal {
        private int size;
        private int weight;

        public Animal(int size, int weight) {
            this.size = size;
            this.weight = weight;
        }

        public void eat() {
            System.out.println("Animals like eating");
        }
    }

    class Dog extends Animal {
        int legs;
        public Dog(int size, int weight, int legs) {
            super(size, weight);
            this.legs = legs;
        }
        //Animal is the parent and
    }
}
