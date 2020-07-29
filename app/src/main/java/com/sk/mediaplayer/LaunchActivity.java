package com.sk.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;

public class LaunchActivity extends AppCompatActivity {

    private Handler handler;
    private boolean has;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        handler=new Handler();
        has=false;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMain();
            }
        },2000);
    }

    private void startMain() {
        if(!has){
            has=true;
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        startMain();//快速启动
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(null);//全部去除
    }

}
