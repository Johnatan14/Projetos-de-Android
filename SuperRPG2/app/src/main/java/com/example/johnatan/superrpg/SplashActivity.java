package com.example.johnatan.superrpg;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {
    private static int TEMPO = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                startActivity(ir);
                finish();
            }
        },TEMPO);
    }
}
