package com.test.designpattern.abstaractfactorypattern;

/**
 * @author Batman create on 2019-04-26 15:08
 */
public class Green implements Color {
    /**
     * 绿颜色的填充方法
     */
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
