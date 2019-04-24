package com.test.designpattern.decorator;

/**
 * @author Batman create on 2019-04-24 10:06
 */
public class Rectangle implements Shape{
    /**
     * shape 打印具体的形状
     */
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
