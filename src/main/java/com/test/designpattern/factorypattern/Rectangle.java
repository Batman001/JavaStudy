package com.test.designpattern.factorypattern;

/**
 * @author Batman create on 2019-04-26 14:55
 * 实现Shape接口的实体类
 */
public class Rectangle implements Shape {
    /**
     * 描述矩形图像的形状的draw接口
     */
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");

    }
}
