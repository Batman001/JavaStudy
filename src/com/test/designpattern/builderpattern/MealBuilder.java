package com.test.designpattern.builderpattern;

/**
 * @author Batman create on 2019-05-13 14:31
 */
public class MealBuilder {
    /**
     * 组合得到鸡肉汉堡套餐的方法
     * @return Meal 鸡肉汉堡套餐
     */
    public Meal prepareMeatMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new CocaCoke());
        return meal;
    }
}
