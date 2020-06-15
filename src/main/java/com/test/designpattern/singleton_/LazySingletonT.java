package com.test.designpattern.singleton_;

import com.sun.imageio.plugins.common.LZWCompressor;
import sun.reflect.generics.reflectiveObjects.LazyReflectiveObjectGenerator;

/**
 * <p>懒汉式单例模式</p>
 *
 * @author : sunchao
 * date : 2020-06-15 09:42
 **/
public class LazySingletonT {

    // 静态实例
    private static LazySingletonT instance = null;

    //  私有化构造函数
    private LazySingletonT(){

    }

    // 线程安全的getInstance的方法
    private static synchronized LazySingletonT getInstance(){
        if(instance == null) {
            instance = new LazySingletonT();
        }
        return instance;
    }








}
