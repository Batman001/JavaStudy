package com.company.caini.property;

/**
 * Created by sunchao on 2018/6/28.
 */
public class LifePotion extends Item {

    @Override
    public void effect(){
        System.out.println("血瓶使用后,可以回血");
    }

    @Override
    public boolean disposable() {
        return true;
    }

    @Override
    public void attack() {

    }

}
