package com.test.designpattern.singleton_;


/**
 * <p>单例模式（懒汉式）</p>
 *
 * @author : sunchao
 * date : 2020-06-15 19:26
 **/
public class SingletonBaseLazy {

    private static SingletonBaseLazy instance = null;

    private SingletonBaseLazy() {}

    private static synchronized SingletonBaseLazy getInstance() {
        if(instance == null) {
            instance = new SingletonBaseLazy();
        }
        return instance;
    }


}
