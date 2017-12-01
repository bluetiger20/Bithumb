package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class IntroActivity extends AppCompatActivity {
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_intro);
        mHandler = new Handler();
        mHandler.postDelayed(mrun, 1500);
    }

    Runnable mrun = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(IntroActivity.this, MainActivity.class); //인텐트 생성(현 액티비티, 새로 실행할 액티비티)
            startActivity(i);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            //overridePendingTransition 이란 함수를 이용하여 fade in,out 효과를줌. 순서가 중요
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mHandler.removeCallbacks(mrun);
    }

}
