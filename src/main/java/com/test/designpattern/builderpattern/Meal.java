package com.test.designpattern.builderpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Batman create on 2019-05-13 14:23
 * 套餐类 负责返回套餐的组合细节以及相关价格和包装信息
 */
public class Meal {
    /**
     * items 存放套餐的相关组成信息
     */
    private List<Item> items = new ArrayList<>();

    /**
     * 为套餐添加具体食物的方法
     * @param item 具体食物
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * 返回套餐的价格
     * @return float 包含饮料、汉堡的价格
     */
    public float getCost(){
        float cost = 0.0f;
        for(Item item : items){
            cost += item.price();
        }
        return cost;
    }

    /**
     * 展示并打印套餐里的具体食物的信息
     */
    public void showItems(){
        for(Item item : items){
            System.out.printf("Item名称：" + item.name());
            System.out.printf(",包装：" + item.packing().pack());
            System.out.printf(",价格：" + item.price());
            System.out.println();
        }
    }

}
