package com.lanlengran.hushucomputertiaowen.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lanlengran.hushucomputertiaowen.R;
import com.lanlengran.hushucomputertiaowen.ui.ifragment.IFragment02;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by dobest on 2016/10/27.
 */

public class Fragment02 extends Fragment implements IFragment02 {
    private TextView textView01;
    private TextView textView02;
    private TextView textView03;
    private TextView textView04;
    private TextView textView05;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_02, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {

        textView01 = (TextView) view.findViewById(R.id.textView);
        textView02 = (TextView) view.findViewById(R.id.textView2);
        textView03 = (TextView) view.findViewById(R.id.textView3);
        textView04 = (TextView) view.findViewById(R.id.textView4);
        textView05 = (TextView) view.findViewById(R.id.textView5);
        initDate(view);
    }

    /**
     * 此处设置参数
     *
     * @param view
     */
    private void initDate(View view) {
        Random r = new Random();
//        textView01.setText("温 度 "+doubleToString(24+r.nextGaussian()*0.5)+"℃");
        textView02.setText("湿 度 " + doubleToString(60 + r.nextGaussian() * 1.5) + "％");
        textView03.setText("光照度 " + (int) (3348 + r.nextGaussian() * 100));
        textView04.setText("土壤湿度 " + doubleToString(40 + r.nextGaussian() * 1.5) + "％");
        textView05.setText("二氧化碳 " + (int) (335 + r.nextGaussian() * 10));
//        if (AppConfig.Style==AppConfig.Style_ShuiPei){
//            view.findViewById(R.id.roil_temp_item).setVisibility(View.GONE);
//        }
    }

    @Override
    public void getDateSuccess(int temp, int humidity, int illumination, int soilHumidity, int CO2) {
        // textView01.setText();
    }

    @Override
    public void showError() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    public static String doubleToString(double d) {
        String string;
        BigDecimal b = new BigDecimal(d);
        double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        string = Double.toString(f1);
        return string;
    }
}
