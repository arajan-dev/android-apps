package com.aravind.colorblindtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button;
    ImageView imageView;
    int index;
    Animation moveOut,moveIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moveOut = new TranslateAnimation(0,800,0,0);
        moveOut.setDuration(1000);
        moveOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.startAnimation(moveIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        moveIn = new TranslateAnimation(-800,0,0,0);
        moveIn.setDuration(1000);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        // 3 image - get ID for 3 images..
        int id1 = imageView.getContext().getResources().getIdentifier("ic_launcher","drawable",getPackageName());
        int id2 = imageView.getContext().getResources().getIdentifier("ic_launcher_round","drawable",getPackageName());
        final int[] idArray = {id1,id2};

        index = 0;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = index + 1;
                if(index > 1) {
                    index = 0;
                }

                imageView.setImageResource(idArray[index]);
                imageView.startAnimation(moveIn);

            }
        });

    }


}
