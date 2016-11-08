package com.simbaliu.ninecirclechainrings;

import android.app.Activity;
import android.os.Bundle;

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
        for (int i = 1; i < 2; i++) {
            LittleCircleView littleCircleView = new LittleCircleView(this, mainCircleView);
            littleCircleView.setContent(i);
        }
    }

}
