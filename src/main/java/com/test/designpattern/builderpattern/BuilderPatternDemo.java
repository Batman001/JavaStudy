package com.test.designpattern.builderpattern;

/**
 * @author Batman create on 2019-05-13 14:34
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mb = new MealBuilder();
        Meal meatMeal = mb.prepareMeatMeal();
        System.out.println("鸡肉汉堡套餐:");
        meatMeal.showItems();
        System.out.println("该套餐一共花费：" + meatMeal.getCost());

        Meal vegMeal = mb.prepareVegMeal();
        System.out.println("蔬菜汉堡套餐：");
        vegMeal.showItems();
        System.out.println("该套餐一共花费：" + vegMeal.getCost());
    }
}
