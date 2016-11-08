package com.simbaliu.ninecirclechainrings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.simbaliu.ninecirclechainrings.utils.CusConstants;
import com.simbaliu.ninecirclechainrings.utils.ScreenUtils;
import com.simbaliu.ninecirclechainrings.view.BallView;
import com.simbaliu.ninecirclechainrings.view.MainCircleView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.main_circle_view)
    MainCircleView mainCircleView;

    private int appSize[];
    private int appWidth, appHeight;
    private int ruler;
    private int numPosition17[][] = new int[][]{};
    private boolean checkState[] = new boolean[33];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initScreen();
        initNumPosition();
        initView();
    }

    /**
     * 初始化屏幕尺寸
     */
    private void initScreen() {
        appSize = ScreenUtils.getScreenSize(this);
        appWidth = appSize[0];
        appHeight = appSize[1];
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(appWidth, appWidth);
        mainCircleView.setLayoutParams(params);
        ruler = appWidth / 2;
    }

    /**
     * 初始化数字位置
     */
    private void initNumPosition() {
        int circle1Sqar = (int) (Math.sqrt(2) / 2 * CusConstants.CIRCLE1);
        int circle2Sqar = (int) (Math.sqrt(2) / 2 * CusConstants.CIRCLE2);
        int circle3Sqar = (int) (Math.sqrt(2) / 2 * CusConstants.CIRCLE3);
        int circle4Sqar = (int) (Math.sqrt(2) / 2 * CusConstants.CIRCLE4);
        numPosition17 = new int[][]{
                {ruler, ruler - CusConstants.CIRCLE1},      //1
                {ruler - circle3Sqar, ruler - circle3Sqar}, //2
                {ruler, ruler + CusConstants.CIRCLE2},      //3
                {ruler + circle3Sqar, ruler + circle3Sqar}, //4
                {ruler - CusConstants.CIRCLE2, ruler},      //5
                {ruler + circle1Sqar, ruler - circle1Sqar}, //6
                {ruler + CusConstants.CIRCLE1, ruler},      //7
                {ruler - CusConstants.CIRCLE4, ruler},      //8
                {ruler + circle4Sqar, ruler - circle4Sqar}, //9
                {ruler - circle3Sqar, ruler + circle3Sqar}, //10
                {ruler + CusConstants.CIRCLE4, ruler},      //11
                {ruler + circle2Sqar, ruler + circle2Sqar}, //12
                {ruler, ruler - CusConstants.CIRCLE4},      //13
                {ruler - circle4Sqar, ruler - circle4Sqar}, //14
                {ruler - circle2Sqar, ruler + circle2Sqar}, //15
                {ruler, ruler + CusConstants.CIRCLE3},      //16
                {ruler, ruler},                             //17
                {ruler - circle1Sqar, ruler + circle1Sqar}, //18
                {ruler + CusConstants.CIRCLE2, ruler},      //19
                {ruler - circle2Sqar, ruler - circle2Sqar}, //20
                {ruler, ruler - CusConstants.CIRCLE3},      //21
                {ruler + circle1Sqar, ruler + circle1Sqar}, //22
                {ruler, ruler + CusConstants.CIRCLE1},      //23
                {ruler + circle3Sqar, ruler - circle3Sqar}, //24
                {ruler - circle4Sqar, ruler + circle4Sqar}, //25
                {ruler, ruler + CusConstants.CIRCLE4},      //26
                {ruler - CusConstants.CIRCLE1, ruler},      //27
                {ruler - CusConstants.CIRCLE3, ruler},      //28
                {ruler + circle2Sqar, ruler - circle2Sqar}, //29
                {ruler + circle4Sqar, ruler + circle4Sqar}, //30
                {ruler + CusConstants.CIRCLE3, ruler},      //31
                {ruler - circle1Sqar, ruler - circle1Sqar}, //32
                {ruler, ruler - CusConstants.CIRCLE2},      //33
        };
    }

    /**
     * 初始化视图
     */
    private void initView() {
        for (int i = 0; i < 33; i++) {
            final BallView ballView = new BallView(this, mainCircleView);
            ballView.setContent(i + 1);
            final int finalI = i;
            ballView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkState[finalI] = !checkState[finalI];
                    if (checkState[finalI]) {
                        ballView.setBackgroundResource(R.drawable.shape_red_point_checked);
                    } else {
                        ballView.setBackgroundResource(R.drawable.shape_red_point_unchecked);
                    }
                }
            });
            ballView.setPosition(numPosition17[i][0], numPosition17[i][1]);
        }
    }

}
