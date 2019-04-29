package com.example.a1.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * Created by 1 on 2019/4/15.
 */

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 实际测量工作在这个方法中完成,measure()是final
     * 绘制流程中,测量/定位/绘制 有可能会调用多次,根据布局的复杂程度来的
     * @param widthMeasureSpec 父容器对子类的宽度的期望
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //widthMeasureSpec,测量模式和大小。
        //measure()--->onMeasure()--->setMeasuredDimension()-->setMeasuredDimensionRaw()
        //不指定其大小测量的模式，View想多大就多大
        //MeasureSpec.UNSPECIFIED 0
        // 精确值模式,指定为具体数值
        //EXACTLY 1
        //最大值模式
        //AT_MOST 2<<30
        //size,像素值:px值 = dp值 * dpi(屏幕像素密度)/160
        //200dp == 525px
        //px = 200*420/160
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d("tag", "size: "+size+",mode:"+(mode>>30));
    }

    /**
     * 定位,确定view位置
     * @param l
     * @param t
     * @param r
     * @param b
     */
    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
        Log.d("tag", "layout: ");
    }

    /**
     * 绘制,确定view长什么样的
     * @param canvas
     */
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Log.d("tag", "draw: ");
    }
}
