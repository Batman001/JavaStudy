package com.test.designpattern.builder;

/**
 * @author Batman create on 2019-04-24 15:16
 * 食物 接口 可以得到食物的名称、包装、价格
 */
public interface Item {

    /**
     * 返回item的名称
     * @return String
     */
    String name();

    /**
     * 返回item的包装
     * @return Packing
     */
    Packing packing();

    /**
     * 返回item的价格
     * @return float
     */
    float price();

}
