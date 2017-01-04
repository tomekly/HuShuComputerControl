package com.lanlengran.hushucomputertiaowen.ui.ifragment;

/**
 * Created by dobest on 2016/10/27.
 */

public interface IFragment02 {
    void getDateSuccess(int temp,int humidity,int illumination,int soilHumidity,int CO2);
    void showError();
    void showProgress();
    void hideProgress();
}
