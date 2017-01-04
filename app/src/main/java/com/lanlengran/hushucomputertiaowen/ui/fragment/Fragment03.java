package com.lanlengran.hushucomputertiaowen.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lanlengran.hushucomputertiaowen.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lecho.lib.hellocharts.formatter.SimpleAxisValueFormatter;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * Created by dobest on 2016/10/27.
 */

public class Fragment03 extends Fragment {
    private LineChartView chart;
    private LineChartData data;

    private int maxNumberOfLines = 1;
    private int numberOfPoints = 6;
    private int numberOfLines = 1;

    List<AxisValue> axisValues = new ArrayList<AxisValue>();

    float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];

    private boolean hasAxes = true;
    private boolean hasAxesNames = false;
    private boolean hasLines = true; //是否有折线
    private boolean hasPoints = true; //是否有值点
    private ValueShape shape = ValueShape.CIRCLE;  //值点形状
    private boolean isFilled = false;  //折线到坐标轴间是否填充颜色
    private boolean hasLabels = false;
    private boolean isCubic = false; //曲线还是折线
    private boolean hasLabelForSelected = true;
    private boolean pointsHaveDifferentColor;
    double[] temps = {18.5, 19.0, 19.0, 19.1, 19.1, 19.2, 19.4, 20.3, 21.2, 21.9, 22.5, 22.5, 23.4, 21.3, 22.4, 23.5, 22.3, 21.0, 20.2, 19.5, 18.9, 17.5, 16.4, 14.3};
    double[] humidity = {45.3, 45.2, 46.6, 46.9, 46.5, 46.9, 46.9, 47.0, 57.6, 57.5, 60.4, 58.5, 58.5, 57.0, 57.3, 56.8, 55.6, 54.4, 54.3, 45.5, 45.6, 45.4, 45.5, 45.0};
    int[] illumination = {18, 22, 26, 29, 33, 36, 38, 39, 50, 55, 50, 40, 36, 32, 33, 30, 23, 22, 20, 19, 15, 14, 13, 13};
    int[] soilHumidity = {43, 50, 49, 43, 45, 43, 53, 53, 40, 45, 43, 45, 53, 45, 46, 32, 35, 44, 43, 40, 36, 34, 33, 30};
    int[] CO2 = {494, 493, 495, 496, 503, 506, 469, 464, 513, 538, 501, 507, 510, 438, 526, 507, 490, 507, 522, 512, 532, 508, 511, 490};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_03, container, false);
        chart = (LineChartView) view.findViewById(R.id.chart);
        //    generateValues();
        generateData();
        return view;
    }

//    private void generateValues() {
//        for (int i = 0; i < maxNumberOfLines; ++i) {
//            for (int j = 0; j < numberOfPoints; ++j) {
//                randomNumbersTab[i][j] =(float) (Math.random() * 70f+30);
//                axisValues.add(new AxisValue(j).setLabel("10月"+j+"日"));
//            }
//        }
//    }

    private void generateData() {

        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numberOfLines; ++i) {

            List<PointValue> values = new ArrayList<PointValue>();
            List<PointValue> values2 = new ArrayList<PointValue>();
            List<PointValue> values3 = new ArrayList<PointValue>();
            List<PointValue> values4 = new ArrayList<PointValue>();
            List<PointValue> values5 = new ArrayList<PointValue>();
            List<PointValue> values6 = new ArrayList<PointValue>(); //该操作为了撑开纵轴
            values6.add(new PointValue(0, 0));
            values6.add(new PointValue(1, 100));
            Random r = new Random();
            for (int j = 0; j < 24; ++j) {
                //    values.add(new PointValue(j, (float) temps[j]));
                //       values2.add(new PointValue(j, (float) humidity[j]));
                //     values3.add(new PointValue(j, illumination[j]));
//                values4.add(new PointValue(j, soilHumidity[j]));
//                values5.add(new PointValue(j, CO2[j]/10));
                if (j < 13)
                    values.add(new PointValue(j, (float) (14 + 0.7 * j + r.nextGaussian() * 0.8)));
                else
                    values.add(new PointValue(j, (float) (23 - 0.9 * (j - 13) + r.nextGaussian() * 0.8)));
                values2.add(new PointValue(j, (float) (60 + r.nextGaussian() * 3)));
                values3.add(new PointValue(j, (float) (3348 / 100 + r.nextGaussian() * 1.5)));
                values4.add(new PointValue(j, (float) (40 + r.nextGaussian() * 3)));
                values5.add(new PointValue(j, (float) (335 / 10 + r.nextGaussian() * 1.5)));
                //    Log.d("qin", "generateData: "+r.nextGaussian());

                //   if (j%10==0)
                axisValues.add(new AxisValue(j).setLabel(j + ":00"));

            }

            Line line = new Line(values);
            line.setColor(getResources().getColor(R.color.fragment02_item_01_shadow_color));
            line.setShape(shape);
            line.setCubic(isCubic);
            line.setFilled(isFilled);
            line.setHasLabels(hasLabels);
            line.setHasLabelsOnlyForSelected(hasLabelForSelected);
            line.setHasLines(hasLines);
            line.setHasPoints(hasPoints);
            if (pointsHaveDifferentColor) {
                line.setPointColor(ChartUtils.COLORS[(i + 1) % ChartUtils.COLORS.length]);
            }
            Line line2 = new Line(values2);
            Line line3 = new Line(values3);
            Line line4 = new Line(values4);
            Line line5 = new Line(values5);
            Line line6 = new Line(values6);
            line2.setHasPoints(hasPoints);
            line3.setHasPoints(hasPoints);
            line4.setHasPoints(hasPoints);
            line5.setHasPoints(hasPoints);
            line2.setCubic(isCubic);
            line3.setCubic(isCubic);
            line4.setCubic(isCubic);
            line5.setCubic(isCubic);
            line2.setColor(getResources().getColor(R.color.fragment02_item_02_shadow_color));
            line3.setColor(getResources().getColor(R.color.fragment02_item_03_shadow_color));
            line4.setColor(getResources().getColor(R.color.fragment02_item_04_shadow_color));
            line5.setColor(getResources().getColor(R.color.fragment02_item_05_shadow_color));
            line6.setColor(getResources().getColor(R.color.fragment02_item_bg_end));
            lines.add(line);
            lines.add(line2);
            lines.add(line3);
            lines.add(line4);
            lines.add(line5);
            lines.add(line6);
        }

        data = new LineChartData(lines);

        if (hasAxes) {
            Axis axisX = new Axis(axisValues);
            Axis axisY = new Axis(new ArrayList<AxisValue>());
            if (hasAxesNames) {
                axisX.setName("Axis X");
                axisY.setName("Axis Y");
            }
            axisY.setMaxLabelChars(3);
            //     axisX.setFormatter(new SimpleAxisValueFormatter().setAppendedText("km".toCharArray()));

//            List<AxisValue> axisValues = new ArrayList<AxisValue>();
//            List<PointValue> values = new ArrayList<PointValue>();
//            for (int i = 0; i < numberOfPoints; ++i) {
//                values.add(new PointValue(i, 0));
//                axisValues.add(new AxisValue(i).setLabel(days[i]));
//            }
//            data.setAxisXBottom(new Axis(axisValues));
            data.setAxisXBottom(axisX);
            data.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

        data.setBaseValue(Float.NEGATIVE_INFINITY);
        chart.setLineChartData(data);

    }

    /**
     * Recalculated height values to display on axis. For this example I use auto-generated height axis so I
     * override only formatAutoValue method.
     */
    private static class HeightValueFormatter extends SimpleAxisValueFormatter {

        private float scale;
        private float sub;
        private int decimalDigits;

        public HeightValueFormatter(float scale, float sub, int decimalDigits) {
            this.scale = scale;
            this.sub = sub;
            this.decimalDigits = decimalDigits;
        }

        @Override
        public int formatValueForAutoGeneratedAxis(char[] formattedValue, float value, int autoDecimalDigits) {
            float scaledValue = (value + sub) / scale;
            return super.formatValueForAutoGeneratedAxis(formattedValue, scaledValue, this.decimalDigits);
        }
    }
}
