package com.test.designpattern.singleton_;

import java.io.*;

/**
 * @author Batman create on 2019-06-27 14:32
 */
public class SingletonTestSer {
    public static void main(String[] args) {
        System.out.println("================序列化安全=============");

        DCLSingleton singleton1 = DCLSingleton.getInstance();
        DCLSingleton singleton2 = null;

        try {
            ObjectOutput output=new ObjectOutputStream(new FileOutputStream("singleton.ser"));
            output.writeObject(singleton1);
            output.close();

            ObjectInput input=new ObjectInputStream(new FileInputStream("singleton.ser"));
            singleton2= (DCLSingleton) input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
        // 此时执行结果 显然 singleton1 和 singleton2的hashCode不一样 序列化会破坏单例模式

        // 如果在DCLSingleton中添加重写readResolve 使其可以返回同一个实例

    }
}
