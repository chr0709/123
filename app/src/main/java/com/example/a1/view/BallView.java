package com.example.a1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 1 on 2019/4/17.
 */

public class BallView extends View {

    private Bitmap mBitmap;
    private Paint mPaint;
    private float mLeft;
    private float mTop;

    public BallView(Context context) {
        super(context);
    }

    public BallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap,mLeft,mTop,mPaint);

    }
    //获取触摸位置

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mLeft = event.getX();
        mTop = event.getY();
        //重写绘制
        invalidate();
//        return super.onTouchEvent(event);//只能点击，不能滑动
        return true;//方法消费事件
    }
}
