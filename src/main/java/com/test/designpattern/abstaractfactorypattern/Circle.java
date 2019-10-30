package com.test.designpattern.abstaractfactorypattern;

/**
 * @author Batman create on 2019-04-26 14:57
 * 实现Shape接口的实体类
 */
public class Circle implements Shape {
    /**
     * 描述圆形图像的形状的draw接口
     */
    @Override
    public void draw() {
        System.out.println("Inside Circle :: draw() method.");
    }
}
