package com.company.caini.personal;

/**
 * Created by sunchao on 2018/7/3.
 */

public class Cat extends Animal implements Pet {

    public Cat(String name){
        super(name, 4);
    }

    public Cat(){
        this("");
    }

    public void eat(){
        System.out.println(name + "喵喵喵,吃东西咯");
    }

    public String getName(){
        return this.name;
    }

    public void play(){
        System.out.println(name + "喵喵喵,我只跟聪明的主人玩耍");
    }

    public void SetName(String catName){
        this.name = catName;
    }
}
