package com.test.designpattern.decoratorpattern;

/**
 * 首先，定义组件类，也是装饰者和被装饰者的超类 BaseSweet.java 甜品类
 * @author Batman create on 2019-04-24 13:59
 */
public abstract class BaseSweet {
    private String description = "BaseSweet";

    public String getDescription() {
        return description;
    }

    /**
     * 返回甜品价格
     * @return double
     */
    public abstract double cost();
}
