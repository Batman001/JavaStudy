package com.test.designpattern.factorypattern;

/**
 * @author Batman create on 2019-04-26 14:56
 * 实现Shape接口的实体类
 */
public class Square implements Shape{

    /**
     * 描述正方形图像的形状的draw接口
     */
    @Override
    public void draw() {
        System.out.println("Inside Square :: draw() method.");

    }
}
