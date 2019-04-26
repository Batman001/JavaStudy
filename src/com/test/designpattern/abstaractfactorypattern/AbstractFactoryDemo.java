package com.test.designpattern.abstaractfactorypattern;

/**
 * @author Batman create on 2019-04-26 15:21
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // 获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");

        // 获取颜色工厂
        AbstractFactory colorFacoty = FactoryProducer.getFactory("COLOR");

        Shape s1 = shapeFactory.getShape("RECTANGLE");
        s1.draw();

        Color c1 = colorFacoty.getColor("RED");
        c1.fill();
    }
}
