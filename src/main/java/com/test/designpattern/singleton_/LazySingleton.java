package com.test.designpattern.singleton_;

/**
 * @author Batman create on 2019-06-27 09:53
 * 2. 懒汉式单例模式
 * 实例化的时机挪到了 getInstance()方法中，
 * 做到了 lazy init ，但也失去了类加载时期初始化的线程安全保障。
 * 因此使用了 synchronized 关键字来保障线程安全。
 * 但这显然是一个无差别攻击，管你要不要同步，管你是不是多线程，一律给我加锁。
 * 这也带来了额外的性能消耗。这点问题肯定难不倒程序员们，
 * 于是，双重检查锁定(DCL, Double Check Lock) 应运而生。
 */
public class LazySingleton {

    private static LazySingleton mInstance;

    private LazySingleton(){}

    public static synchronized LazySingleton getInstance(){
        if(mInstance == null) {
            mInstance = new LazySingleton();
        }
        return mInstance;
    }

}
