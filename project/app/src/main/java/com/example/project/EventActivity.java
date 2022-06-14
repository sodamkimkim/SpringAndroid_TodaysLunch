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
    private Message message;
    private EventActivity context;

    private EventActivity() {
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
         * 메세지를 수신하여 동작을 처리
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

        /**
         * 이벤트 처리
         */
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
                    sleepThread(0);
                }

                for(int i = 1; i < 5; i++){
                    switch (i){
                        case 1:
                            sentMessage(i);
                            Animation slideAnimation = AnimationUtils
                                    .loadAnimation(context, R.anim.translate_anim);
                            radomballImg.startAnimation(slideAnimation);
                            sleepThread(i);
                            break;
                        case 2:
                            sentMessage(i);
                            sleepThread(i);
                            break;
                        case 3:
                            sentMessage(i);
                            sleepThread(i);
                            break;
                        case 4:
                            sentMessage(i);
                    }
                }
            }
        });
        thread.start();
    }

    /**
     * 메세지를 보내는 기능
     * @param msgWhat (msg 내용)
     */
    private void sentMessage(int msgWhat){
        message = handler.obtainMessage();
        if(msgWhat == 1){
            message.what = msgWhat;
        }else if (msgWhat == 2){
            message.what = msgWhat;
        }else if(msgWhat == 3){
            message.what = msgWhat;
        }else if(msgWhat == 4){
            message.what = msgWhat;
        }
        handler.sendMessage(message);
    }

    /**
     * 쓰레드 슬립
     * @param type
     */
    private void sleepThread(int type){
        if(type == 1){
            type = 1200;
        }else if (type == 2){
            type = 250;
        }else if(type == 3){
            type = 50;
        }else{
            type = 100;
        }
        try {
            Thread.sleep(type);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}