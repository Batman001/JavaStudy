package com.test.designpattern.decoratorpattern;

/**
 * 第三， 定义抽象装饰者类 AbstractDecorator
 * @author Batman create on 2019-04-24 14:05
 */
public abstract class AbstractDecorator extends BaseSweet {
    /**
     * 返回装饰者类的描述信息
     * @return String
     */
    @Override
    public abstract String getDescription();

}
