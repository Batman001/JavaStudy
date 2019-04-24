package com.test.designpattern.decoratorpattern;

/**
 * @author Batman create on 2019-04-24 14:08
 */
public class FruitAbstractDecorator extends AbstractDecorator {
    private BaseSweet sweet;

    FruitAbstractDecorator(BaseSweet sweet){
        this.sweet = sweet;
    }
    /**
     * 返回装饰者类的描述信息
     *
     * @return String
     */
    @Override
    public String getDescription() {
        return sweet.getDescription() + ",水果";
    }

    /**
     * 返回甜品加水果的价格
     *
     * @return double
     */
    @Override
    public double cost() {
        return sweet.cost() + 10;
    }
}
