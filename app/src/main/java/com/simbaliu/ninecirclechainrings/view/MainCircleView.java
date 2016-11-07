package com.simbaliu.ninecirclechainrings.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

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
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int x = getMeasuredWidth() / 2;
        int y = getMeasuredHeight() / 2;
        canvas.drawCircle(x, y, 200, mPaint);
        canvas.drawCircle(x, y, 300, mPaint);
        canvas.drawCircle(x, y, 400, mPaint);
        canvas.drawCircle(x, y, 500, mPaint);
    }
}
