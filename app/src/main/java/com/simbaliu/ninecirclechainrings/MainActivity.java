package com.simbaliu.ninecirclechainrings;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.simbaliu.ninecirclechainrings.bean.NumVo;
import com.simbaliu.ninecirclechainrings.utils.CusConstants;
import com.simbaliu.ninecirclechainrings.utils.ScreenUtils;
import com.simbaliu.ninecirclechainrings.view.BallView;
import com.simbaliu.ninecirclechainrings.view.MainCircleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @BindView(R.id.main_view)
    LinearLayout mainView;
    @BindView(R.id.main_circle_view)
    MainCircleView mainCircleView;
    @BindView(R.id.btn_rotate_reverse)
    Button btnRotateReverse;

    private int appSize[];
    private int appWidth, appHeight;
    private int ruler;
    private boolean checkState[] = new boolean[33];

    private List<NumVo> circleData1;
    private List<NumVo> circleData2;
    private List<NumVo> circleData3;
    private List<NumVo> circleData4;
    private boolean num17Checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initScreen();
        initData();
        initView();
    }

    public boolean isNum17Checked() {
        return num17Checked;
    }

    public void setNum17Checked(boolean num17Checked) {
        this.num17Checked = num17Checked;
    }

    /**
     * 初始化屏幕尺寸
     */
    private void initScreen() {
        appSize = ScreenUtils.getScreenSize(this);
        appWidth = appSize[0];
        appHeight = appSize[1];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(appWidth, appWidth);
        mainCircleView.setLayoutParams(params);
        ruler = appWidth / 2;
    }

    private void initData() {
        int circle1Sqar = (int) (Math.sqrt(2) / 2 * CusConstants.CIRCLE1);
        int circle2Sqar = (int) (Math.sqrt(2) / 2 * CusConstants.CIRCLE2);
        int circle3Sqar = (int) (Math.sqrt(2) / 2 * CusConstants.CIRCLE3);
        int circle4Sqar = (int) (Math.sqrt(2) / 2 * CusConstants.CIRCLE4);
        circleData1 = new ArrayList<NumVo>();
        circleData2 = new ArrayList<NumVo>();
        circleData3 = new ArrayList<NumVo>();
        circleData4 = new ArrayList<NumVo>();
        int[] circle1Num = new int[]{1, 6, 7, 22, 23, 18, 27, 32};
        int[][] circle1Pos = new int[][]{
                {ruler, ruler - CusConstants.CIRCLE1},      //1
                {ruler + circle1Sqar, ruler - circle1Sqar}, //6
                {ruler + CusConstants.CIRCLE1, ruler},      //7
                {ruler + circle1Sqar, ruler + circle1Sqar}, //22
                {ruler, ruler + CusConstants.CIRCLE1},      //23
                {ruler - circle1Sqar, ruler + circle1Sqar}, //18
                {ruler - CusConstants.CIRCLE1, ruler},      //27
                {ruler - circle1Sqar, ruler - circle1Sqar}, //32
        };
        int[] circle2Num = new int[]{33, 29, 19, 12, 3, 15, 5, 20};
        int[][] circle2Pos = new int[][]{
                {ruler, ruler - CusConstants.CIRCLE2},      //33
                {ruler + circle2Sqar, ruler - circle2Sqar}, //29
                {ruler + CusConstants.CIRCLE2, ruler},      //19
                {ruler + circle2Sqar, ruler + circle2Sqar}, //12
                {ruler, ruler + CusConstants.CIRCLE2},      //3
                {ruler - circle2Sqar, ruler + circle2Sqar}, //15
                {ruler - CusConstants.CIRCLE2, ruler},      //5
                {ruler - circle2Sqar, ruler - circle2Sqar}, //20
        };
        int[] circle3Num = new int[]{21, 24, 31, 4, 16, 10, 28, 2};
        int[][] circle3Pos = new int[][]{
                {ruler, ruler - CusConstants.CIRCLE3},      //21
                {ruler + circle3Sqar, ruler - circle3Sqar}, //24
                {ruler + CusConstants.CIRCLE3, ruler},      //31
                {ruler + circle3Sqar, ruler + circle3Sqar}, //4
                {ruler, ruler + CusConstants.CIRCLE3},      //16
                {ruler - circle3Sqar, ruler + circle3Sqar}, //10
                {ruler - CusConstants.CIRCLE3, ruler},      //28
                {ruler - circle3Sqar, ruler - circle3Sqar}, //2
        };
        int[] circle4Num = new int[]{13, 9, 11, 30, 26, 25, 8, 14};
        int[][] circle4Pos = new int[][]{
                {ruler, ruler - CusConstants.CIRCLE4},      //13
                {ruler + circle4Sqar, ruler - circle4Sqar}, //9
                {ruler + CusConstants.CIRCLE4, ruler},      //11
                {ruler + circle4Sqar, ruler + circle4Sqar}, //30
                {ruler, ruler + CusConstants.CIRCLE4},      //26
                {ruler - circle4Sqar, ruler + circle4Sqar}, //25
                {ruler - CusConstants.CIRCLE4, ruler},      //8
                {ruler - circle4Sqar, ruler - circle4Sqar}, //14
        };
        for (int i = 0; i < circle1Num.length; i++) {
            NumVo numVo = new NumVo();
            numVo.setNum(circle1Num[i]);
            numVo.setPosition(circle1Pos[i]);
            circleData1.add(numVo);
        }
        for (int i = 0; i < circle2Num.length; i++) {
            NumVo numVo = new NumVo();
            numVo.setNum(circle2Num[i]);
            numVo.setPosition(circle2Pos[i]);
            circleData2.add(numVo);
        }
        for (int i = 0; i < circle3Num.length; i++) {
            NumVo numVo = new NumVo();
            numVo.setNum(circle3Num[i]);
            numVo.setPosition(circle3Pos[i]);
            circleData3.add(numVo);
        }
        for (int i = 0; i < circle4Num.length; i++) {
            NumVo numVo = new NumVo();
            numVo.setNum(circle4Num[i]);
            numVo.setPosition(circle4Pos[i]);
            circleData4.add(numVo);
        }
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mainCircleView.removeAllViews();
        for (int i = 0; i < circleData1.size(); i++) {
            final BallView ballView = new BallView(this, mainCircleView);
            ballView.setContent(circleData1.get(i).getNum());
            final int finalI = i;
            ballView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    circleData1.get(finalI).setChecked(!circleData1.get(finalI).isChecked());
                    if (circleData1.get(finalI).isChecked()) {
                        ballView.setBackgroundResource(R.drawable.shape_red_point_checked);
                    } else {
                        ballView.setBackgroundResource(R.drawable.shape_red_point_unchecked);
                    }
                }
            });
            if (circleData1.get(i).isChecked()) {
                ballView.setBackgroundResource(R.drawable.shape_red_point_checked);
            } else {
                ballView.setBackgroundResource(R.drawable.shape_red_point_unchecked);
            }
            ballView.setPosition(circleData1.get(i).getPosition()[0], circleData1.get(i).getPosition()[1]);
        }
        for (int i = 0; i < circleData2.size(); i++) {
            final BallView ballView = new BallView(this, mainCircleView);
            ballView.setContent(circleData2.get(i).getNum());
            final int finalI = i;
            ballView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    circleData2.get(finalI).setChecked(!circleData2.get(finalI).isChecked());
                    if (circleData2.get(finalI).isChecked()) {
                        ballView.setBackgroundResource(R.drawable.shape_red_point_checked);
                    } else {
                        ballView.setBackgroundResource(R.drawable.shape_red_point_unchecked);
                    }
                }
            });
            if (circleData2.get(i).isChecked()) {
                ballView.setBackgroundResource(R.drawable.shape_red_point_checked);
            } else {
                ballView.setBackgroundResource(R.drawable.shape_red_point_unchecked);
            }
            ballView.setPosition(circleData2.get(i).getPosition()[0], circleData2.get(i).getPosition()[1]);
        }
        for (int i = 0; i < circleData3.size(); i++) {
            final BallView ballView = new BallView(this, mainCircleView);
            ballView.setContent(circleData3.get(i).getNum());
            final int finalI = i;
            ballView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    circleData3.get(finalI).setChecked(!circleData3.get(finalI).isChecked());
                    if (circleData3.get(finalI).isChecked()) {
                        ballView.setBackgroundResource(R.drawable.shape_red_point_checked);
                    } else {
                        ballView.setBackgroundResource(R.drawable.shape_red_point_unchecked);
                    }
                }
            });
            if (circleData3.get(i).isChecked()) {
                ballView.setBackgroundResource(R.drawable.shape_red_point_checked);
            } else {
                ballView.setBackgroundResource(R.drawable.shape_red_point_unchecked);
            }
            ballView.setPosition(circleData3.get(i).getPosition()[0], circleData3.get(i).getPosition()[1]);
        }
        for (int i = 0; i < circleData4.size(); i++) {
            final BallView ballView = new BallView(this, mainCircleView);
            ballView.setContent(circleData4.get(i).getNum());
            final int finalI = i;
            ballView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    circleData4.get(finalI).setChecked(!circleData4.get(finalI).isChecked());
                    if (circleData4.get(finalI).isChecked()) {
                        ballView.setBackgroundResource(R.drawable.shape_red_point_checked);
                    } else {
                        ballView.setBackgroundResource(R.drawable.shape_red_point_unchecked);
                    }
                }
            });
            if (circleData4.get(i).isChecked()) {
                ballView.setBackgroundResource(R.drawable.shape_red_point_checked);
            } else {
                ballView.setBackgroundResource(R.drawable.shape_red_point_unchecked);
            }
            ballView.setPosition(circleData4.get(i).getPosition()[0], circleData4.get(i).getPosition()[1]);
        }
        final BallView ballView = new BallView(this, mainCircleView);
        ballView.setContent(17);
        ballView.setPosition(ruler, ruler);
        ballView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNum17Checked(!isNum17Checked());
                if (isNum17Checked()) {
                    ballView.setBackgroundResource(R.drawable.shape_red_point_checked);
                } else {
                    ballView.setBackgroundResource(R.drawable.shape_red_point_unchecked);
                }
            }
        });
    }

    @OnClick(R.id.btn_rotate_reverse)
    public void onClick() {
        for (int i = 0; i < circleData1.size(); i++) {
            if (i == 0) {
                if (circleData1.get(i).isChecked()) {
                    circleData1.get(i).setChecked(false);
                    circleData1.get(7).setChecked(true);
                    break;
                }
            } else {
                if (circleData1.get(i).isChecked()) {
                    circleData1.get(i).setChecked(false);
                    circleData1.get(i - 1).setChecked(true);
                }
            }
        }
        for (int i = 0; i < circleData2.size(); i++) {
            if (i == 0) {
                if (circleData2.get(i).isChecked()) {
                    circleData2.get(i).setChecked(false);
                    circleData2.get(7).setChecked(true);
                    break;
                }
            } else {
                if (circleData2.get(i).isChecked()) {
                    circleData2.get(i).setChecked(false);
                    circleData2.get(i - 1).setChecked(true);
                }
            }
        }
        for (int i = 0; i < circleData3.size(); i++) {
            if (i == 0) {
                if (circleData3.get(i).isChecked()) {
                    circleData3.get(i).setChecked(false);
                    circleData3.get(7).setChecked(true);
                    break;
                }
            } else {
                if (circleData3.get(i).isChecked()) {
                    circleData3.get(i).setChecked(false);
                    circleData3.get(i - 1).setChecked(true);
                }
            }
        }
        for (int i = 0; i < circleData4.size(); i++) {
            if (i == 0) {
                if (circleData4.get(i).isChecked()) {
                    circleData4.get(i).setChecked(false);
                    circleData4.get(7).setChecked(true);
                    break;
                }
            } else {
                if (circleData4.get(i).isChecked()) {
                    circleData4.get(i).setChecked(false);
                    circleData4.get(i - 1).setChecked(true);
                }
            }
        }

        initView();
    }
}
