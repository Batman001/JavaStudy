package com.test.designpattern.adapter.objadapter;

import com.test.designpattern.adapter.classadapter.AC220;
import com.test.designpattern.adapter.classadapter.DC5;

/**
 * @author Batman create on 2019-05-13 09:59
 * 基于对象适配器模式 （objAdapter)
 */
public class PowerAdapter implements DC5 {
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
        int output = 0;
        if(mAC220 != null){
            output = mAC220.output220V()/44;
        }
        return output;
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
