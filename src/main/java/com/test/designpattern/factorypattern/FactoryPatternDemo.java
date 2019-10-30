package com.test.designpattern.factorypattern;

/**
 * @author Batman create on 2019-04-26 15:02
 * 使用该工厂，通过传递类型信息来获取实体类的对象。
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1  = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2  = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3  = shapeFactory.getShape("SQUARE");
        shape3.draw();

    }

}
