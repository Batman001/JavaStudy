package com.test.designpattern.singleton;

import java.util.Vector;

/**
 * @author Batman create on 2019-04-22 16:05
 * 采用"影子实例"的方法为单例对象的属性进行同步更新
 */
public class SingletonTest {
    private static SingletonTest instance = null;
    private Vector properties = null;

    public Vector getProperties() {
        return properties;
    }

    private SingletonTest(){

    }

    private static synchronized void syncInit(){
        if(instance == null){
            instance = new SingletonTest();
        }
    }

    public static SingletonTest getInstance(){
        if(instance == null){
            syncInit();
        }
        return instance;
    }

    public void updateProperties(){
        SingletonTest shadow = new SingletonTest();
        properties = shadow.getProperties();

    }




}
