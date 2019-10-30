package com.test.designpattern.abstaractfactorypattern;

/**
 * @author Batman create on 2019-04-26 15:15
 * 创建一个工厂创造器/生成器类 通过传递形状或者颜色创建工厂
 */
public class FactoryProducer {
    static AbstractFactory getFactory(String choice){
        if(("SHAPE").equalsIgnoreCase(choice)){
            return new ShapeFactory();
        }else if(("COLOR").equalsIgnoreCase(choice)) {
            return new ColorFactory();
        }
        return null;
    }

}
