package com.test.designpattern.singleton;

/**
 * @author Batman create on 2019-04-22 16:01
 * 线程安全的类
 */
public class Singleton1 {
    private static Singleton1 instance = null;
    private Singleton1(){}

    private static synchronized void syncInit(){
        if(instance == null){
            instance = new Singleton1();
        }
    }

    public static Singleton1 getInstance(){
        if(instance == null){
            syncInit();
        }
        return instance;
    }
}
