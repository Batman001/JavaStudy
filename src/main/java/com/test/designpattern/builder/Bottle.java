package com.test.designpattern.builder;

/**
 * @author Batman create on 2019-04-24 15:25
 * 实现packing的接口的冷饮的瓶子类
 */
public class Bottle implements Packing {
    /**
     * 冷饮包装的接口实现
     *
     * @return String
     */
    @Override
    public String pack() {
        return "Bottle";
    }
}
