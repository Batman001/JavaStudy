package com.test.designpattern.builder;

/**
 * @author Batman create on 2019-04-24 16:02
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mb = new MealBuilder();
        Meal vegMeal = mb.prepareVegMeal();
        System.out.println("Veg Meal:");
        vegMeal.showItems();
        System.out.println("Total cost:" + vegMeal.getCost());


        Meal noVegMeal = mb.prepareNonVegMeal();
        System.out.println("Chicken Burger Meal:");
        noVegMeal.showItems();
        System.out.println("Total cost:" + noVegMeal.getCost());

    }
}
