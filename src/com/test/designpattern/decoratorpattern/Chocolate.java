package com.test.designpattern.decoratorpattern;

/**
 * @author Batman create on 2019-04-26 11:06
 */
public class Chocolate extends BaseSweet {
    @Override
    public String getDescription() {
        return "一块巧克力";
    }

    /**
     * 返回甜品巧克力的价格
     *
     * @return double
     */
    @Override
    public double cost() {
        return 300;
    }
}
