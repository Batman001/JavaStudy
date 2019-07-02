package com.test.designpattern.singleton_;

/**
 * @author Batman create on 2019-06-27 11:03
 * 4. 静态内部类模式 它和饿汉式一样基于类加载时器的线程安全，但是又做到了延迟加载。
 * SingletonHolder 是一个静态内部类，当外部类被加载的时候并不会初始化。
 * 当调用 getInstance() 方法时，才会被加载。
 */
public class StaticInnerSingleton {

    private StaticInnerSingleton(){}

    private static class SingletonHolder {
        private static final StaticInnerSingleton mInstance = new StaticInnerSingleton();

    }

    public static StaticInnerSingleton getInstance(){
        return SingletonHolder.mInstance;
    }
}
