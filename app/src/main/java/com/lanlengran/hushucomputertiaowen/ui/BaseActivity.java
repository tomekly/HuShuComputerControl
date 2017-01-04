package com.lanlengran.hushucomputertiaowen.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by dobest on 2016/9/28.
 */

public class BaseActivity extends AppCompatActivity {
    protected Context mContext;
    protected TextView titleTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }
}
