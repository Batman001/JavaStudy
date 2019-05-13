package com.test.designpattern.adapterdemo.interfaceadapter;

/**
 * @author Batman create on 2019-05-13 10:16
 */
public interface DCOutput {
    /**
     * 转换为5V的手机充电接口
     * @return 输出电压
     */
    int output5V();

    /**
     * 转换为9V的手机充电接口
     * @return 输出电压
     */
    int output9V();

    /**
     * 转换为12V的手机充电接口
     * @return 输出电压
     */
    int output12V();

    /**
     * 转换为24V的手机充电接口
     * @return 输出电压
     */
    int output24V();
}
