package com.test.designpattern.builder;

/**
 * @author Batman create on 2019-04-24 15:20
 */
public abstract class BaseBurger implements Item {

    /**
     * 返回item的包装
     *
     * @return Packing
     */
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    /**
     * 返回Burger的价格
     *
     * @return float
     */
    @Override
    public abstract float price();
}
