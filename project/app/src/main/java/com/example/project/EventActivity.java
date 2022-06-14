package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class EventActivity extends AppCompatActivity{
    private static EventActivity instance;
    private ImageView randomMuchineImg;
    private ImageView radomballImg;
    private Handler handler;

    private EventActivity context;

    public EventActivity() {
    }

    public static EventActivity newInstance() {
        if(instance == null){
            instance = new EventActivity();
        }
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        randomMuchineImg = findViewById(R.id.radomMuchine);
        radomballImg = findViewById(R.id.radomball);
        context = this;
        radomballImg.setVisibility(View.INVISIBLE);


        /**
         * 여기다가 MainActivity.class 에다가 바꿔 넣을꺼 끼면 됨
         */
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                switch (message.what){
                    case 1:
                        radomballImg.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        radomballImg.setImageResource(R.drawable.machineballcrack);
                        break;
                    case 3:
                        radomballImg.setVisibility(View.GONE);
                        break;
                    case 4:
                        Intent intent = new Intent(getApplicationContext(), AppRecommendationDetailActivity.class);
                        startActivity(intent);
                        finish();
                }
                return true;
            }
        });


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 0; i < 50; i++){
                    switch (i%4){
                        case 0:
                            randomMuchineImg.setImageResource(R.drawable.machine2);
                            break;
                        case 1:
                            randomMuchineImg.setImageResource(R.drawable.machine3);
                            break;
                        case 2:
                            randomMuchineImg.setImageResource(R.drawable.machine4);
                            break;
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Message message = handler.obtainMessage();
                message.what = 1;
                handler.sendMessage(message);
                Animation slideAnimation = AnimationUtils
                        .loadAnimation(context, R.anim.translate_anim);
                radomballImg.startAnimation(slideAnimation);
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                message = handler.obtainMessage();
                message.what = 2;
                handler.sendMessage(message);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                message = handler.obtainMessage();
                message.what = 3;
                handler.sendMessage(message);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                message = handler.obtainMessage();
                message.what = 4;
                handler.sendMessage(message);
            }
        });
        thread.start();
    }
}