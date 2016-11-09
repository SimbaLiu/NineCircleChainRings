package com.simbaliu.ninecirclechainrings.bean;

import java.io.Serializable;

/**
 * Created by LiuXing on 2016/11/8.
 */
public class NumVo implements Serializable {
    private boolean isChecked;
    private int num;
    private int[] position;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}
