package com.test.designpattern.singleton_;

/**
 * <p>单例模式（饿汉式）</p>
 *
 * @author : Batman
 * date : 2020-06-15 19:28
 **/
public class SingletonBaseHungry {

    private static SingletonBaseHungry instance = new SingletonBaseHungry();

    private SingletonBaseHungry(){}

    private static synchronized SingletonBaseHungry getInstance() {
        return instance;
    }

}
