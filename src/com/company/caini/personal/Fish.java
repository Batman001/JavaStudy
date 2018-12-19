package com.company.caini.personal;

/**
 * Created by sunchao on 2018/7/3.
 */
public class Fish extends Animal implements Pet {

    private String name;

    public Fish(){}

    @Override
    public void walk(){
        System.out.println(name+"作为水生动物,是不会走路的吧 啊哈哈哈");
    }

    @Override
    public String getName(){
        return this.name;
    }

    public void eat(){
        System.out.println(name + "我只吃小虾米");
    }

    public void play(){
        System.out.println(name+"作为水生生物,可能只会鱼水之欢了吧");
    }

    public void SetName(String fishName){
        this.name = fishName;
    }
}
