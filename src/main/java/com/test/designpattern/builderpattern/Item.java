package com.test.designpattern.builderpattern;

/**
 * @author Batman create on 2019-05-13 14:06
 * 食物的基本功能接口
 */
public interface Item {
    /**
     * 返回食物名称
     * @return 名称
     */
    String name();

    /**
     * 食物的价格
     * @return float 价格
     */
    float price();

    /**
     * 不同食物的类型 返回不同包装结果 只需要食物的基类实现即可
     * @return 接口功能 不同 Item 有不同的包装类型
     */
    Packing packing();

}
