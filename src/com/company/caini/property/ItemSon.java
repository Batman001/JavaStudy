package com.company.caini.property;

import com.company.caini.character.HeroItem;

/**
 * Created by Batman on 2018/8/1.
 */
public class ItemSon extends Item implements HeroItem{
    String name;
    int price;
    public ItemSon(){}
    public ItemSon(String name){
        this.name = name;

    }
    @Override
    public boolean disposable(){
        System.out.println("重写抽象类的抽象方法");
        return false;
    }

    @Override
    public void showId() {
        System.out.println("我是Item");
    }

    @Override
    public String toString(){
        return "当前Item的名字是" + this.name;

    }

}
