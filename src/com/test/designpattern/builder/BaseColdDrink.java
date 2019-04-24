package com.test.designpattern.builder;

/**
 * @author Batman create on 2019-04-24 15:22
 */
public abstract class BaseColdDrink implements Item{
    /**
     * 返回item的名称
     *
     * @return String
     */
    @Override
    public String name() {
        return null;
    }

    /**
     * 返回item的包装
     *
     * @return Packing
     */
    @Override
    public Packing packing() {
        return new Bottle();
    }

    /**
     * 返回coldDrink(冷饮)的价格
     *
     * @return float
     */
    @Override
    public abstract float price();
}
