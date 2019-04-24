package com.test.designpattern.decoratorpattern;

/**
 * @author Batman create on 2019-04-24 14:14
 */
public class SweetDecoratorDemo {
    public static void main(String[] args) {
        Cake cake = new Cake();
        System.out.println(cake.getDescription() + "总共花费" + cake.cost());

        FruitAbstractDecorator fruitDecorator = new FruitAbstractDecorator(cake);
        System.out.println(fruitDecorator.getDescription() + "总共花费" + fruitDecorator.cost());

        CandleAbstractDecorator candleDecorator = new CandleAbstractDecorator(fruitDecorator);
        System.out.println(candleDecorator.getDescription() + "总共花费" + candleDecorator.cost());

        FruitAbstractDecorator f2 = new FruitAbstractDecorator(candleDecorator);
        System.out.println(f2.getDescription() + "总共花费" + f2.cost());



    }

}
