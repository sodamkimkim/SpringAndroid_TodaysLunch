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

import com.example.project.databinding.ActivityEventBinding;
import com.example.project.databinding.ActivityMenuDetailBinding;

public class EventActivity extends AppCompatActivity{

    private ImageView randomMuchineImg;
    private ImageView radomballImg;
    private Message message;
    private EventActivity context;
    private Handler handler = new Handler(new Handler.Callback() {
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

    public EventActivity() {
        context = this;
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
        radomballImg.setVisibility(View.INVISIBLE);
        playAnimation();

    }

    /**
     * 이벤트 처리
     */
    private void playAnimation(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                shuffleMuchineAnim();
                pullUpBallAnim();
            }
        }).start();
    }

    /**
     * 머신이 섞이는 애니메이션 구성
     */
    private void shuffleMuchineAnim(){
        for(int i = 0; i < 50; i++){
            switch (i%3){
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
    }

    /**
     * 공이 떠올랐다 쪼개지는 애니메이션 구성
     */
    private void pullUpBallAnim(){
        for(int msgWhat = 1; msgWhat < 5; msgWhat++){
            switch (msgWhat){
                case 1:
                    sentMessage(msgWhat);
                    Animation slideAnimation = AnimationUtils
                            .loadAnimation(context, R.anim.translate_anim);
                    radomballImg.startAnimation(slideAnimation);
                    sleepThread(msgWhat);
                    break;
                case 2:
                    sentMessage(msgWhat);
                    sleepThread(msgWhat);
                    break;
                case 3:
                    sentMessage(msgWhat);
                    sleepThread(msgWhat);
                    break;
                case 4:
                    sentMessage(msgWhat);
            }
        }
    }

    
    /**
     * 메세지를 보내는 기능
     * @param msgWhat (msg 내용)
     */
    private void sentMessage(int msgWhat){
        message = handler.obtainMessage();
        message.what = msgWhat;
        handler.sendMessage(message);
    }

    /**
     * 쓰레드 슬립
     * @param msgWhat
     */
    private void sleepThread(int msgWhat){
        if(msgWhat == 1){
            msgWhat = 1200;
        }else if (msgWhat == 2){
            msgWhat = 250;
        }else if(msgWhat == 3){
            msgWhat = 50;
        }else{
            msgWhat = 100;
        }
        try {
            Thread.sleep(msgWhat);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}