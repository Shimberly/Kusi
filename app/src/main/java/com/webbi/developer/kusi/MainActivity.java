package com.webbi.developer.kusi;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final int splash=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                verificarLogin();
            }
        },splash);
    }


    public void verificarLogin(){

        Intent itemintent = new Intent(MainActivity.this, Principal.class);
        MainActivity.this.startActivity(itemintent);

        finish();
    }
    @Override
    public void onBackPressed (){
        return;
    }

}
