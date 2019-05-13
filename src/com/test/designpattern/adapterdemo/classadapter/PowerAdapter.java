package com.test.designpattern.adapterdemo.classadapter;

/**
 * @author Batman create on 2019-05-13 09:27
 * 类适配器模式
 */
public class PowerAdapter extends AC220 implements DC5 {
    @Override
    public int output220V() {
        return super.output220V();
    }

    /**
     * 转换为手机锂电池需要的5V直流电
     * @return 输出5V
     */
    @Override
    public int output5V() {
        int output = output220V();
        return (output/44);
    }

    public void initClassAdapter(){
        DC5 dc5 = new PowerAdapter();
        dc5.output5V();
    }

    public static void main(String[] args) {
        PowerAdapter pat = new PowerAdapter();
        pat.initClassAdapter();
        System.out.println(pat.output5V());

    }
}
