package com.test.designpattern.builderpattern;

/**
 * @author Batman create on 2019-05-13 14:14
 */
public class Bottle implements Packing {
    /**
     * 食物包装的接口 包装功能
     *
     * @return 包装的名称
     */
    @Override
    public String pack() {
        return "Bottle";
    }
}
