package com.test.designpattern.singleton_;

import java.lang.reflect.Constructor;

/**
 * @author Batman create on 2019-06-27 14:50
 * 枚举单例 测试代码
 */
public class SingletonTestEnum {
    public static void main(String[] args) {
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = null;

        try{
            // 测试反射 对枚举单例类带来的影响
            Class<EnumSingleton> clz = EnumSingleton.class;
            Constructor<EnumSingleton> constructor = clz.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            singleton2 = constructor.newInstance("test", 1);

        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());

        // java.lang.IllegalArgumentException: Cannot reflectively create enum objects 枚举单例也是天生反射安全的。
        // 枚举单例天生不允许反射

    }
}
