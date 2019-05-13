package com.test.designpattern.adapterdemo.objadapter;

import com.test.designpattern.adapterdemo.classadapter.AC220;
import com.test.designpattern.adapterdemo.interfaceadapter.DCOutput;

/**
 * @author Batman create on 2019-05-13 09:59
 * 对象适配器模式
 */
public class PowerAdapter implements DCOutput {
    /**
     * 220V 充电交流电
     */
    protected AC220 mAC220;

    public PowerAdapter(AC220 mAC220) {
        this.mAC220 = mAC220;
    }

    /**
     * 转换为手机锂电池需要的5V直流电
     * @return 输出5V
     */
    @Override
    public int output5V() {
        return mAC220.output220V();
    }

    @Override
    public int output9V() {
        return mAC220.output220V();
    }

    @Override
    public int output12V() {
        return mAC220.output220V();
    }

    @Override
    public int output24V() {
        return mAC220.output220V();
    }

    public static void initObjAdapter(){
        PowerAdapter adapter = new PowerAdapter(new AC220());
        adapter.output5V();
        System.out.println(adapter.output5V());
    }

    public static void main(String[] args) {
        initObjAdapter();
    }
}
