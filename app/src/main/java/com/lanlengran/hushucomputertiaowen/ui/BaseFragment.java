package com.lanlengran.hushucomputertiaowen.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;


/**
 * Created by dobest on 2016/9/28.
 */

public class BaseFragment extends Fragment {
   protected Context mContext;
    private Toolbar toolbar;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext =getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mContext =null;
    }
    protected void showActivity(Class cla){
        Intent it=new Intent(mContext,cla);
        startActivity(it);
    }
}
