package com.example.a1.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 1 on 2019/4/17.
 */

public class MyView2 extends View {

    private Paint mArcPaint;
    private Paint mCirclePaint;
    private int mStartX;
    private int mStartY;
    private int mEndX;
    private int mEndY;
    private Paint mPaint;
    private Bitmap mBitmap;
    private Path mPath;
    private RectF mRectF;

    public MyView2(Context context) {
        super(context);
    }

    public MyView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //直线
        mStartX = 50;
        mStartY = 50;
        mEndX = 300;
        mEndY = 300;
        mPaint = new Paint();
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.parseColor("#00ff00"));
        mPaint.setAntiAlias(true);//去除锯齿

        //空心圆画笔
        mCirclePaint = new Paint();
        mCirclePaint.setStrokeWidth(8);
        mCirclePaint.setColor(Color.parseColor("#00ff00"));
        mCirclePaint.setStyle(Paint.Style.STROKE);//空心画笔
        mCirclePaint.setAntiAlias(true);//去除锯齿
        //图片
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background);
        //多边形
        int x1 = 50;
        int y1 = 50;
        int x2 = 280;
        int y2 = 100;
        int x3 = 150;
        int y3 = 280;
        mPath = new Path();
        mPath.moveTo(x1,y1);
        mPath.lineTo(x2,y2);
        mPath.lineTo(x3,y3);
        mPath.lineTo(x1,y1);

        //扇形
        mRectF = new RectF(50, 50, 280, 280);
        mArcPaint = new Paint();
        mArcPaint.setStrokeWidth(8);
        mArcPaint.setColor(Color.parseColor("#00ff00"));
        mArcPaint.setAntiAlias(true);//去除锯齿

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //裁剪
//        canvas.clipPath(mPath);
        //直线
//        canvas.drawLine(mStartX, mStartY, mEndX, mEndY, mPaint);
        //圆
//        canvas.drawCircle(150,150,100,mPaint);
        //空心圆
//        canvas.drawCircle(150,150,100,mCirclePaint);
        //画图片
//        canvas.drawBitmap(mBitmap,0,0,mPaint);
        //多边形
//        canvas.drawPath(mPath,mPaint);
        //扇形
        //startAngle 起始角度
        //true为实心扇形
        //false为扇形边边去除直角三角形
        canvas.drawArc(mRectF,0,80,false,mArcPaint);

    }
}
