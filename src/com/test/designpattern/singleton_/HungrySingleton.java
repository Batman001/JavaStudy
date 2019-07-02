package com.test.designpattern.singleton_;

/**
 * @author Batman create on 2019-06-27 09:52
 * 1.饿汉式单例模式
 * 私有构造器是单例的一般套路，保证不能在外部新建对象。
 * 饿汉式在类加载时期就已经初始化实例，由于类加载过程是线程安全的，所以饿汉式默认也是线程安全的。
 * 它的缺点也很明显，我真正需要单例对象的时机是我调用 getInstance() 的时候，而不是类加载时期。
 * 如果单例对象是很耗资源的，如数据库，socket 等等，无疑是不合适的。于是就有了懒汉式。
 */
public class HungrySingleton {
    private static final HungrySingleton mInstance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance(){
        return mInstance;
    }
}
