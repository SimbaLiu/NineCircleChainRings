package com.simbaliu.ninecirclechainrings.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.simbaliu.ninecirclechainrings.R;

/**
 * 未读消息空间，可自由设置大小、颜色、位置
 */
public class BallView extends TextView {
    /* 设置默认的对齐排列方式 */
    private static final int DEFAULT_MARGIN_DIP = 1;
    private static final int DEFAULT_PADDING_DIP = 1;
    private int pointMargin;
    private int paddingPixels;

    /* 用于保存背景图 */
    private ShapeDrawable pointBg;
    /* 显示未读条数 */
    private int content = 0;
    private String contentStr;
    /* 背景颜色 */
    private int colorBg = 0xffff0033;
    /* 内容颜色 */
    private int colorContent = Color.WHITE;
    /* 显示大小 */
    private int sizeContent = 12;
    /* 背景大小 */
    private int sizeBg = (int) (sizeContent * 1.5);
    /* 是否显示 */
    private boolean isShown;

    private Context context;
    private View orginView;
    private boolean isSmall = false;
    private int left, top;

    public BallView(Context context, View target) {
        super(context);
        this.context = context;
        this.orginView = target;
        init();
    }

    public BallView(Context context, View target, boolean small) {
        super(context);
        this.context = context;
        this.orginView = target;
        this.isSmall = small;
        setSizeContent(4);
        init();
    }

    /* 设置未读条数，默认为0 */
    public void setContent(int content) {
        this.content = content;
        setText("" + content);
    }

    /* 设置未读条数，默认为0 */
    public void setContent(String content) {
        this.contentStr = content;
        setText("" + content);
    }

    /* 设置内容字体颜色，默认为Color.WHITE */
    public void setColorContent(int colorContent) {
        this.colorContent = colorContent;
        setTextColor(colorContent);
    }

    /* 设置背景颜色，默认为Color.RED */
    public void setColorBg(int colorBg) {
        this.colorBg = colorBg;
        pointBg = getDefaultBackground();
        if (isSmall) {
            setBackgroundResource(R.drawable.shape_red_point_small);
        } else {
            setBackgroundResource(R.drawable.shape_red_point_unchecked);
        }
    }

    public void setPosition(int left, int top) {
        this.left = left;
        this.top = top;
        setPositionParams(left, top);
    }

    /* 设置显示位置参数 */
    private void setPositionParams(int left, int top) {
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.setMargins(left - dipToPixels(16), top - dipToPixels(16), 0, 0);
        setLayoutParams(params);
    }

    /* 设置内容字体大小，默认为15 */
    public void setSizeContent(int sizeContent) {
        this.sizeContent = sizeContent;
        setTextSize(sizeContent);
        this.sizeBg = (int) (sizeContent * 1.5);
    }

    /* 显示小红点 */
    public void show() {
        this.setVisibility(View.VISIBLE);
        isShown = true;
    }

    /* 隐藏小红点 */
    public void hide() {
        this.setVisibility(View.GONE);
        isShown = false;
    }

    /* 画一个背景 */
    private ShapeDrawable getDefaultBackground() {
        int r = sizeBg;
        float[] outerR = new float[]{r, r, r, r, r, r, r, r};
        RoundRectShape rectShape = new RoundRectShape(outerR, null, null);
        ShapeDrawable shap = new ShapeDrawable(rectShape);
        shap.getPaint().setColor(colorBg);

        return shap;
    }

    /* 初始化 */
    private void init() {
        pointMargin = dipToPixels(DEFAULT_MARGIN_DIP);

        setTypeface(Typeface.DEFAULT_BOLD);
        paddingPixels = dipToPixels(DEFAULT_PADDING_DIP);
        setPadding(0, 0, 0, 0);

        setContent(content);
        setColorContent(colorContent);
        setSizeContent(sizeContent);
        setPosition(left, top);
        setColorBg(colorBg);
        setGravity(Gravity.CENTER);

        isShown = false;

        if (this.orginView != null) {
            restartDraw(this.orginView);
        }
    }

    /* 将target从父view中去掉，取而代之为一个包含target和point的framLayout */
    private void restartDraw(View target) {
        LayoutParams lp = target.getLayoutParams();
        ViewParent parent = target.getParent();
        FrameLayout framLayout = new FrameLayout(context);

        ViewGroup viewGroup = (ViewGroup) parent;
        int index = viewGroup.indexOfChild(target);

        viewGroup.removeView(target);
        viewGroup.addView(framLayout, index, lp);
        framLayout.addView(target);
        framLayout.addView(this);

        viewGroup.invalidate();  // View 刷新
    }

    private int dipToPixels(int dip) {
        Resources r = getResources();
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip,
                r.getDisplayMetrics());
        return (int) px;
    }

}
