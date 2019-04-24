package com.test.designpattern.decoratorpattern;

/**
 * @author Batman create on 2019-04-24 14:11
 */
public class CandleAbstractDecorator extends AbstractDecorator {
    private BaseSweet sweet;
    CandleAbstractDecorator(BaseSweet sweet) {
        this.sweet = sweet;
    }
    /**
     * 返回装饰者类的描述信息
     *
     * @return String
     */
    @Override
    public String getDescription() {
        return sweet.getDescription() + ",蜡烛";
    }

    /**
     * 返回甜品 + 蜡烛 价格
     *
     * @return double
     */
    @Override
    public double cost() {
        return sweet.cost() + 5;
    }
}
