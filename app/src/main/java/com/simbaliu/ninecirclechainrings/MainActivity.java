package com.simbaliu.ninecirclechainrings;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.simbaliu.ninecirclechainrings.view.LittleCircleView;
import com.simbaliu.ninecirclechainrings.view.MainCircleView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.main_circle_view)
    MainCircleView mainCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        mainCircleView = new MainCircleView(this);
        for (int i = 1; i < 4; i++) {
            LittleCircleView littleCircleView = new LittleCircleView(this);
            littleCircleView.setCoordinateAndNum(i * 10, i * 10, i);
            mainCircleView.addView(littleCircleView);
        }
        mainCircleView.invalidate();
        Log.e("initView", "viewCount-->" + mainCircleView.getChildCount());
    }

}
