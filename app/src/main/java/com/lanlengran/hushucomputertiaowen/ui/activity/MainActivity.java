package com.lanlengran.hushucomputertiaowen.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.lanlengran.hushucomputertiaowen.R;
import com.lanlengran.hushucomputertiaowen.ui.fragment.Fragment01;
import com.lanlengran.hushucomputertiaowen.ui.fragment.Fragment02;
import com.lanlengran.hushucomputertiaowen.ui.fragment.Fragment03;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment01;
    private Fragment fragment02;
    private Fragment fragment03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        fragment01=new Fragment01();
        fragment02=new Fragment02();
        fragment03=new Fragment03();

        getSupportFragmentManager().beginTransaction().replace(R.id.homepage_fragment01,fragment01).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.homepage_fragment02,fragment02).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.homepage_fragment03,fragment03).commit();

//防止休眠
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
}
