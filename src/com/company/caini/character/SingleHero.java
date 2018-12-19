package com.company.caini.character;

/**
 * Created by sunchao on 2018/6/27.
 */
public class SingleHero {
    private int id;
    public String name;
    protected float hp;
    int moveSpeed;
    static String copyRight;

    private SingleHero(){
    }   //(1)构造方法私有化
    private static SingleHero instance = new SingleHero(); // (2)静态属性指向实例

    public static SingleHero getInstance(){
        if(null == instance){
            instance = new SingleHero();
        }
        return instance;
    }
    // (3) getInstance 返回第二步静态属性指向实例


}
