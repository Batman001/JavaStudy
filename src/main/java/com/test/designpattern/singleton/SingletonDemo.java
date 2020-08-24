package com.test.designpattern.singleton;

/**
 * @author Batman create on 2019-05-14 10:45
 */
public class SingletonDemo {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.printf("通过单例模式判断生成的实例是否为同一个实例，判断结果如：%s \n",(String.valueOf(s1 == s2)));

        Singleton1 s3 = Singleton1.getInstance();
        Singleton1 s4 = Singleton1.getInstance();

        System.out.println(s3 == s4);

        SingletonTest s5 = SingletonTest.getInstance();
        SingletonTest s6 = SingletonTest.getInstance();


        System.out.println(s5 == s6);



    }


}
