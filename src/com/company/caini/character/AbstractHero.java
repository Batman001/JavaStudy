package com.company.caini.character;

/**
 * Created by sunchao on 2018/7/2.
 */
public abstract class AbstractHero {
    String name;

    float hp;

    float armor;

    int moveSpeed;

    public static void main(String[] args) {
        //但是一旦被声明为了抽象类，就不能够直接被实例化
//        AbstractHero abh = new AbstractHero();
        
    }

    // 抽象方法attack
    // Hero的子类会被要求实现attack方法
    public abstract void attack();


}
