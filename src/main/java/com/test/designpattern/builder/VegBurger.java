package com.test.designpattern.builder;

/**
 * @author Batman create on 2019-04-24 15:29
 */
public class VegBurger extends BaseBurger {
    /**
     * 返回Burger的价格
     *
     * @return float
     */
    @Override
    public float price() {
        return 25.0f;
    }

    /**
     * 返回item的名称
     *
     * @return String
     */
    @Override
    public String name() {
        return "Veg BaseBurger";
    }

}
