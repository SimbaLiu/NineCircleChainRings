package com.simbaliu.ninecirclechainrings.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by LiuXing on 2016/11/7.
 */
public class LittleCircleView extends View {

    Paint mPaint = new Paint();

    public LittleCircleView(Context context) {
        super(context);
        initPaint();
    }

    public LittleCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setFilterBitmap(true);
    }
}
