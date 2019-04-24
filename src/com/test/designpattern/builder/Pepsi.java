package com.test.designpattern.builder;


/**
 * @author Batman create on 2019-04-24 15:32
 */
public class Pepsi extends BaseColdDrink {
    /**
     * 返回coldDrink(冷饮)的价格
     *
     * @return float
     */
    @Override
    public float price() {
        return 35.5f;
    }

    /**
     * 返回item的名称
     *
     * @return String
     */
    @Override
    public String name() {
        return "Pepsi";
    }
}
