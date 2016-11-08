package com.simbaliu.ninecirclechainrings.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.simbaliu.ninecirclechainrings.utils.CusConstants;

/**
 * 四个大圆的View
 * Created by LiuXing on 2016/11/7.
 */
public class MainCircleView extends View {

    Paint mPaint = new Paint();

    public MainCircleView(Context context) {
        super(context);
        initPaint();
    }

    public MainCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setFilterBitmap(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        int x = getMeasuredWidth() / 2;
        int y = getMeasuredHeight() / 2;
        canvas.drawCircle(x, y, CusConstants.CIRCLE1, mPaint);
        canvas.drawCircle(x, y, CusConstants.CIRCLE2, mPaint);
        canvas.drawCircle(x, y, CusConstants.CIRCLE3, mPaint);
        canvas.drawCircle(x, y, CusConstants.CIRCLE4, mPaint);
        //将画笔移到中心点
        canvas.translate(x, y);
        //画米字线
        for (int i = 0; i < 4; i++) {
            canvas.drawLine(0, -CusConstants.CIRCLE4, 0, CusConstants.CIRCLE4, mPaint);
            canvas.rotate(45);
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
    }

}
