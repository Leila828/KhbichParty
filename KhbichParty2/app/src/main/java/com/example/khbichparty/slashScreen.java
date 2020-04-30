package com.example.khbichparty;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class slashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i=new Intent(slashScreen.this,EmailPasswordActivity.class);
                startActivity(i);
                finish();

            }
        },4000);
        final ImageView img=(ImageView) findViewById(R.id.imageView);




        Animation animation =
                AnimationUtils.loadAnimation(this, R.anim.logo);
        img.startAnimation(animation);
    }




    }

