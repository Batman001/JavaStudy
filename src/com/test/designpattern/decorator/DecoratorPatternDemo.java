package com.test.designpattern.decorator;

/**
 * @author Batman create on 2019-04-24 11:19
 * 优点：装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。
 * 缺点：多层装饰比较复杂。
 * 使用场景： 1、扩展一个类的功能。 2、动态增加功能，动态撤销。
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedAbstractShapeDecorator(new Circle());
        Shape redRectangle = new RedAbstractShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("nCircle of red border");
        redCircle.draw();

        System.out.println("nRectangle of red border");
        redRectangle.draw();
    }
}
