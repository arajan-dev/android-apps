package com.aravind.animationdemo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button rButton, tButton;
    ImageView imageView;
    Animation rotation,translation,translation1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rButton = findViewById(R.id.button);
        tButton = findViewById(R.id.button2);
        imageView = findViewById(R.id.imageView);

        //define animations
        rotation = new RotateAnimation(0, 3600,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotation.setDuration(1000);

        rotation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(translation);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        translation1 = new TranslateAnimation(200,-200,0,0);
        translation1.setDuration(1000);
        translation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                    imageView.startAnimation(translation);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        translation = new TranslateAnimation(-200,200,0,0);
        translation.setDuration(1000);
        translation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(translation1);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(rotation);
            }
        });

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(translation);
            }
        });
    }
}
