package com.test.designpattern.builderpattern;

/**
 * @author Batman create on 2019-05-13 14:14
 * 实现了食物接口的 基本汉堡类
 */
public abstract class BaseBurger implements Item{

    /**
     * 抽象类里的返回价格的抽象方法
     * @return 实现该抽象方法的 汉堡的价格
     */
    @Override
    public abstract float price();

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
