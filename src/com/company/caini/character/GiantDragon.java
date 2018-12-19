package com.company.caini.character;

/**
 * Created by sunchao on 2018/6/27.
 */

/*
单例模式三要素
1. 构造方法私有化
2. 静态属性指向实例
3. public static的 getInstance方法，返回第二步的静态属性
 */

// Singleton模式,指的是一个类,在一个JVM中,只有一个实例存在.

public class GiantDragon {

    // 私有化方法使得该类无法在外部通过new 进行实例化
    private GiantDragon(){}

    // 准备一个类属性,指向一个实例化对象,因为是类属性,所以只有一个
    private static GiantDragon instance = new GiantDragon();

    // public static 方法,提供给调用者获取新的实例的方法
    public static GiantDragon getInstance(){
        //第一次访问的时候，发现instance没有指向任何对象，这时实例化一个对象
        // 延迟加载模式
        if(null == instance){
            instance = new GiantDragon();
        }
        //返回 instance指向的对象
        return instance;
    }

}


/*
单例模式三要素
(1) 构造方法私有化
(2) 静态属性指向实例
(3) public staic getInstance方法 返回第二步静态属性指向实例

 */