package com.test.designpattern.builderpattern;

/**
 * @author Batman create on 2019-05-13 14:17
 */
public abstract class BaseColdDrink implements Item {
    /**
     * 具体饮品 返回实现该象方法的具体价格
     * @return float 例如百事和可口可乐的价格
     */
    @Override
    public abstract float price();

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
