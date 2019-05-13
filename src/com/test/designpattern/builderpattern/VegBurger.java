package com.test.designpattern.builderpattern;

/**
 * @author Batman create on 2019-05-13 14:20
 */
public class VegBurger extends BaseBurger {
    /**
     * 抽象类里的返回价格的抽象方法
     *
     * @return 实现该抽象方法的 汉堡的价格
     */
    @Override
    public float price() {
        return 35.0f;
    }

    /**
     * 返回食物名称
     *
     * @return 名称
     */
    @Override
    public String name() {
        return "素食汉堡";
    }
}
