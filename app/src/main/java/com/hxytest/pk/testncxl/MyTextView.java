package com.hxytest.pk.testncxl;


import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by pk on 18/10/13.
 */

public class MyTextView extends android.support.v7.widget.AppCompatTextView {

    public MyTextView(Context context) {
        super(context);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        //追踪当前单击事件速度
        VelocityTracker velocityTracker=VelocityTracker.obtain();
        velocityTracker.addMovement(event);
        switch (action){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                velocityTracker.computeCurrentVelocity(1000);
                int xVelocity= (int) velocityTracker.getXVelocity();
                int yVelocity= (int) velocityTracker.getYVelocity();
                Log.e("-----x轴速度-----",xVelocity+"");
                Log.e("-----y轴速度-----",yVelocity+"");
                break;
            case MotionEvent.ACTION_UP:
                velocityTracker.clear();
                velocityTracker.recycle();
                break;
        }
        return true;
    }
}
