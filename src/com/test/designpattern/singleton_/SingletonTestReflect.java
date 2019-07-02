package com.test.designpattern.singleton_;

import java.lang.reflect.Constructor;

/**
 * @author Batman create on 2019-06-27 11:16
 * 单例模式 测试类
 */
public class SingletonTestReflect {
    public static void main(String[] args) {

        System.out.println("================反射安全=============");
        // 测试DCLSingleton
        DCLSingleton singleton1 = DCLSingleton.getInstance();
        DCLSingleton singleton2 = null;

        try{
            Class<DCLSingleton> clz = DCLSingleton.class;
            Constructor<DCLSingleton> constructor = clz.getDeclaredConstructor();

            constructor.setAccessible(true);
            singleton2 = constructor.newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());

        // 此时执行结果 显然 singleton1 和 singleton2的hashCode不一样 显然反射破坏了单例模式




    }
}
