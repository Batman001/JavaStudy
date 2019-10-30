package com.test.designpattern.builderpattern;

/**
 * @author Batman create on 2019-05-13 14:21
 */
public class Pepsi extends BaseColdDrink {
    /**
     * 具体饮品 返回实现该象方法的具体价格
     *
     * @return float 例如百事和可口可乐的价格
     */
    @Override
    public float price() {
        return 15.0f;
    }

    /**
     * 返回食物名称
     *
     * @return 名称
     */
    @Override
    public String name() {
        return "百事可乐";
    }
}
