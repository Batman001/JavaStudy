package com.test.designpattern.decoratorpattern;

/**
 * 第二，定义被装饰者 蛋糕类
 * @author Batman create on 2019-04-24 14:03
 */
public class Cake extends BaseSweet {
    @Override
    public String getDescription() {
        return "一个蛋糕";
    }

    /**
     * 返回蛋糕价格
     *
     * @return double 66
     */
    @Override
    public double cost() {
        return 66;
    }
}
