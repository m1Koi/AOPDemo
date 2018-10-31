package com.m1ku.aopdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.m1ku.aopdemo.aspectj.checklogin.CheckLogin;
import com.m1ku.aopdemo.aspectj.checklogin.DataManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_collect)
                .setOnClickListener((view)->{
                    startCollection();
                });

        findViewById(R.id.btn_login)
                .setOnClickListener((v -> {
                    Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();

                    DataManager.getInstance().setLogin(true);
                }));

        findViewById(R.id.btn_logout)
                .setOnClickListener(v -> {
                    Toast.makeText(this,"注销成功",Toast.LENGTH_LONG).show();

                    DataManager.getInstance().setLogin(false);
                });
    }

    @CheckLogin
    private void startCollection() {
        Toast.makeText(this,"跳转到收藏页面",Toast.LENGTH_LONG).show();
    }
}
