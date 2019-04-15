package com.test.personal;



/**
 * Created by Batman on 2018/7/3.
 */
public class Spider extends Animal {

    public Spider(String name){
        super(name,8);  //用父类构造器来指明所有蜘蛛都是8条腿
    }

    @Override
    public void eat() {
        System.out.println("蜘蛛吃东西吃的特别少,并且只吃害虫");
    }
}
