package com.example.permissionsafer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.permissionsafer.UI.main_page;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    // 定义全局变量
    public static MainActivity instance = null;

// onCreate方法中赋值


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance = this;
        Log.e("start_page","TOASTED");
        Toast.makeText(this, "欢迎使用用户行为监测系统", Toast.LENGTH_LONG).show();
        Log.e("start_page","STARTED");
        goto_main_page();

    }

    private void goto_main_page(){

        final Intent localIntent=new Intent(this,main_page.class);//你要转向的Activity
        Timer timer=new Timer();
        TimerTask tast=new TimerTask() {
            @Override
            public void run(){
                startActivity(localIntent);//执行
            }
        };
        timer.schedule(tast,3000);
    }
}