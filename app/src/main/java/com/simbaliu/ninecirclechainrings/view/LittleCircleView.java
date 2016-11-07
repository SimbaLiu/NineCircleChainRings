package com.simbaliu.ninecirclechainrings.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LiuXing on 2016/11/7.
 */
public class LittleCircleView extends View {

    Paint mPaint = new Paint();
    Paint textPaint = new Paint();
    private int x, y;
    private int num;

    public LittleCircleView(Context context) {
        super(context);
        initPaint();
    }

    public LittleCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(0);
        mPaint.setAntiAlias(true);
        mPaint.setFilterBitmap(true);

        textPaint.setColor(Color.BLACK);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setTextSize(40);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(x, y, 30, mPaint);
        canvas.drawText("" + num, x, y, textPaint);
    }

    public void setCoordinateAndNum(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

}
