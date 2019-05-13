package com.test.designpattern.adapterdemo.interfaceadapter;

import com.test.designpattern.adapterdemo.classadapter.AC220;

/**
 * @author Batman create on 2019-05-13 10:58
 */
public class PowerAdapter implements DCOutput {

    protected AC220 mAC220;

    public PowerAdapter(AC220 mAC220) {
        this.mAC220 = mAC220;
    }

    /**
     * 转换为5V的手机充电接口
     * 目前先实现5V的充电接口
     * @return 输出电压
     */
    @Override
    public int output5V() {
        return mAC220.output220V();
    }

    /**
     * 转换为9V的手机充电接口
     *
     * @return 输出电压
     */
    @Override
    public int output9V() {
        return mAC220.output220V();
    }

    /**
     * 转换为12V的手机充电接口
     *
     * @return 输出电压
     */
    @Override
    public int output12V() {
        return mAC220.output220V();
    }

    /**
     * 转换为24V的手机充电接口
     *
     * @return 输出电压
     */
    @Override
    public int output24V() {
        return mAC220.output220V();
    }


    private static void initInterfaceAdapter(){

        // 已经实现了的子类
        Power5VAdapter power5VAdapter = new Power5VAdapter(new AC220());
        power5VAdapter.output5V();


        // 直接实现子类
        PowerAdapter powerAdapter =  new PowerAdapter(new AC220()){
            @Override
            public int output5V(){
                int output = 0;
                if(mAC220 != null){
                    output = mAC220.output220V() / 44;
                }
                return output;
            }
        };
        powerAdapter.output5V();
        System.out.println("已经实现了子类的适配器模式输出电压为：" + power5VAdapter.output5V());
        System.out.println("直接实现子类的适配器模式输出电压为：" + powerAdapter.output5V());

    }

    public static void main(String[] args) {
        initInterfaceAdapter();

    }


}
