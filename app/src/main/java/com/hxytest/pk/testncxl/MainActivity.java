package com.hxytest.pk.testncxl;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        findViewById(R.id.tv_one).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this,SecondActivity.class));
//            }
//        });
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
