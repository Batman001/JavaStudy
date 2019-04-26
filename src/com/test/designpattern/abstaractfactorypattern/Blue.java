package com.test.designpattern.abstaractfactorypattern;

/**
 * @author Batman create on 2019-04-26 15:08
 */
public class Blue implements Color {
    /**
     * 蓝颜色的填充方法
     */
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
