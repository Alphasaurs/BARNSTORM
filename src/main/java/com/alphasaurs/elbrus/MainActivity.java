package com.alphasaurs.elbrus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    //variables
    private static int SPLASH_SCREEN=3000;
    Animation logo_animation;
    Animation bottom_animation;
    ImageView logo;
    TextView dev,alpha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //animations
        logo_animation= AnimationUtils.loadAnimation(this,R.anim.logo_animation);
       bottom_animation= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

    //hooks we use
        logo=findViewById(R.id.logo);
        dev=findViewById(R.id.dev);
        alpha=findViewById(R.id.alpha);

        logo.setAnimation(logo_animation);
        dev.setAnimation(bottom_animation);
        alpha.setAnimation(bottom_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}