package com.test.designpattern.builder;

/**
 * @author Batman create on 2019-04-24 15:31
 */
public class Coke extends BaseColdDrink {
    /**
     * 返回coldDrink(冷饮) coke 的价格
     *
     * @return float
     */
    @Override
    public float price() {
        return 30.0f;
    }

    /**
     * 返回item的名称
     *
     * @return String
     */
    @Override
    public String name() {
        return "Coke";
    }
}
