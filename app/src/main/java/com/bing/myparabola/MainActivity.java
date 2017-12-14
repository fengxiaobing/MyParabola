package com.bing.myparabola;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //该写法会报错： java.lang.ClassCastException: java.lang.Float cannot be cast to com.bing.myparabola.Point
        //因为ObjectAnimator会自动赋值，而settranslationX()是Float类型的，所以只能使用ValueAnimator
      /*ObjectAnimator animator = ObjectAnimator.ofObject(button,"translationX",new MyEvaluator(),new Point(0,0));
        animator.setDuration(1500);
        animator.start();*/

      ValueAnimator animator = ValueAnimator.ofObject(new MyEvaluator(),new Point(0,0),new Point(1,1));

        //设置动画运行时间为1.5s
        animator.setDuration(1500);

        //动画属性更新监听器
        //即：值每更新一次，变化一次，该方法被调用一次，我们可以通过该方法，手动对控件的属性赋值
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();

                button.setX(point.getX());

                button.setY(point.getY());


            }
        });

        //开始动画
        animator.start();

    }
}
