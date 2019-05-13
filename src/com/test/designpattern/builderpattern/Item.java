package com.test.designpattern.builderpattern;

/**
 * @author Batman create on 2019-05-13 14:06
 * 食物基类
 */
public interface Item {
    /**
     * 返回食物名称
     * @return 名称
     */
    String name();

    float price();

    Packing packing();

}
