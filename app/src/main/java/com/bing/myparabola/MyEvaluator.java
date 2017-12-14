package com.bing.myparabola;

import android.animation.TypeEvaluator;
import android.util.Log;

/**
 * Created by RF
 * on 2017/12/14.
 */

public class MyEvaluator implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        //fraction 动画的完成度:受插值器影响
        //startValue 初始值
        //endValue 结束值
        //因为抛物线是与时间有关，与坐标无关，所以这里不使用
        Log.e("TAG","startValue"+"==="+startValue.getX()+":"+startValue.getY());
        Log.e("TAG","fraction"+"==="+fraction);
        float x = 400 * (fraction*1.5f);
        float y = 400 * (fraction*1.5f) * (fraction*1.5f);
        // 将计算后的坐标封装到一个新的Point对象中并返回
        Point point = new Point(x,y);
        return point;
    }
}
