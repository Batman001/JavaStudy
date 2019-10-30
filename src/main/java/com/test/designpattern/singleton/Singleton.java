package com.test.designpattern.singleton;

/**
 * @author Batman create on 2019-04-22 15:31
 */
public class Singleton {
    /** 持有私有静态实例，放置被引用，此处赋值为null，目的是为了延迟加载 */
    private static Singleton instance = null;

    /** 私有化构造方法，放置被实例化 */
    private Singleton(){
    }

    /** 此处使用一个内部类来维护单例 */
    private static class SingletonFactory{
        private static Singleton instance = new Singleton();
    }

    /** 获取实例 */
    public static Singleton getInstance(){
        return SingletonFactory.instance;
    }

    /** 如果该对象被用于序列化 可以保证在序列化前后保持一致 */
    public Object readResolve(){
        return getInstance();
    }

}
