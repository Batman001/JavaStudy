package com.test.designpattern.adapterdemo.interfaceadapter;

import com.test.designpattern.adapterdemo.classadapter.AC220;
import com.test.designpattern.adapterdemo.objadapter.PowerAdapter;

/**
 * @author Batman create on 2019-05-13 10:43
 * 适配5V的适配器
 */
public class Power5VAdapter extends PowerAdapter {

    public Power5VAdapter(AC220 mAC220) {
        super(mAC220);
    }

    /**
     * 转换为手机锂电池需要的5V直流电
     *
     * @return 输出5V
     */
    @Override
    public int output5V() {
        int output = 0;
        if (mAC220 != null) {
            output = mAC220.output220V() / 44;
        }
        return output;
    }

}
