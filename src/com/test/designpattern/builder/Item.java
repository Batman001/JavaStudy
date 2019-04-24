package com.test.designpattern.builder;

/**
 * @author Batman create on 2019-04-24 15:16
 * 食物 接口
 */
public interface Item {

    /**
     * 返回item的名称
     * @return String
     */
    public String name();

    /**
     * 返回item的包装
     * @return Packing
     */
    public Packing packing();

    /**
     * 返回item的价格
     * @return float
     */
    public float price();

}
