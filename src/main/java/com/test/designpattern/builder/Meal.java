package com.test.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Batman create on 2019-04-24 15:35
 * Meal类 负责返回套餐的组合细节以及相关价格和包装信息
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for(Item item:items){
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for(Item item:items){
            System.out.print("Item: " + item.name());
            System.out.print(", Packing: " + item.packing().pack());
            System.out.println(", Price: " + item.price());
        }
    }

}
