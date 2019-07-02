package com.test.designpattern.singleton_;

import java.io.Serializable;

/**
 * @author Batman create on 2019-06-27 09:57
 * 3. 双重检查锁定单例模式
 * 注释解释
 * 1、1处做第一次判断，如果已经实例化了，直接返回对象，避免无用的同步消耗。
 * 2、2处对实例化过程进行同步操作，保证单例
 * 3、3处做二次判断 只有mInstance为空时再初始化 看起来时多么的完美，保证线程安全的同时又兼顾性能
 * 但，DCL 存在一个致命缺陷，就是重排序导致的多线程访问可能获得一个未初始化的对象。
 * 参考地址：https://mp.weixin.qq.com/s/dlVXW6aW4wLcLpey9NxPig
 *
 * 修改方法 mInstance 添加关键字volatile修饰
 * 增强了 volatile 的内存语义，对一个volatile 域的写，happens-before 于任意后续对这个 volatile 域的读。
 * volatile 会禁止一些处理器重排序，此时 DCL 就做到了真正的线程安全。
 */
public class DCLSingleton implements Serializable {

    private static volatile DCLSingleton mInstance;

    private DCLSingleton(){
        // 通过反射可能破坏单例模式 因此修改构造函数
        if (mInstance!=null) {
            throw new RuntimeException("想反射我，没门！");
        }
    }

    public static DCLSingleton getInstance(){
        // 1
        if(mInstance == null) {
            // 2
            synchronized (DCLSingleton.class) {
                // 3
                if(mInstance == null) {
                    // 4
                    mInstance = new DCLSingleton();

                }
            }
        }
        return mInstance;
    }

    /**
     * 反序列化时生成了新的实例对象。要修复也很简单，只需要修改反序列化的逻辑就可以了，
     * 即重写 readResolve() 方法，使其返回统一实例。
     * @return 同一个实例
     */
    protected Object readResolve() {
        return getInstance();
    }

}
