package com.lanlengran.hushucomputertiaowen.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanlengran.hushucomputertiaowen.AppConfig;
import com.lanlengran.hushucomputertiaowen.R;

/**
 * Created by dobest on 2016/10/27.
 */

public class Fragment01 extends Fragment {
    private ImageView info_image;
    private int i=0;
    private long lastTime=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_01,container,false);
        info_image= (ImageView) view.findViewById(R.id.info_image);
        initInfo();

        info_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((System.currentTimeMillis()-lastTime)>500){
                        lastTime=System.currentTimeMillis();


                }else {
                    Log.i("qin", "onClick: ");
                        if (AppConfig.Style==AppConfig.Style_TuPei){
                            AppConfig.Style=AppConfig.Style_ShuiPei;
                            initInfo();

                            return;
                        }
                        if (AppConfig.Style==AppConfig.Style_ShuiPei){
                            AppConfig.Style=AppConfig.Style_ShuiTu;
                            initInfo();

                            return;
                        }
                        if (AppConfig.Style==AppConfig.Style_ShuiTu){
                            AppConfig.Style=AppConfig.Style_TuPei;
                            initInfo();
                            return;
                        }

                    Log.i("qin", "Style: "+AppConfig.Style);
                }
            }
        });
        return view;
    }

    private void initInfo() {
        if (AppConfig.Style==AppConfig.Style_TuPei){
            info_image.setImageResource(R.drawable.jh1);
        }
        if (AppConfig.Style==AppConfig.Style_ShuiPei){
            info_image.setImageResource(R.drawable.jh2);
        }
        if (AppConfig.Style==AppConfig.Style_ShuiTu){
            info_image.setImageResource(R.drawable.jh3);
        }
    }
}
