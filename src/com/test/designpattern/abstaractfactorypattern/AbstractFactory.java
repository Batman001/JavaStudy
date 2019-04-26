package com.test.designpattern.abstaractfactorypattern;

/**
 * @author Batman create on 2019-04-26 15:11
 * 为形状和颜色对象创建抽象类来获取工厂
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
