package com.test.genericall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Batman create on 2019-05-21 17:14
 * 泛型类 Box
 */
public class Box<T> {

    private T t;

    public Box(T t) {
        this.t = t;
    }

    public void add(T t){
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void getData(List<?> obj){
        System.out.println("data:" + obj.get(0));
    }

    public static void main(String[] args) {

        System.out.println("====================测试泛型类====================");
        Box<Integer> integerBox = new Box<>(666);
        Box<String> stringBox = new Box<>(" Darkness Forever");
        System.out.printf("整型值为 :%d\n\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());
        System.out.println();

        System.out.println("====================测试泛型通配符====================");
        List<String> name = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        List<Number> number = new ArrayList<>();

        name.add("Icon");
        age.add(19);
        number.add(678);

        getData(name);
        getData(age);
        getData(number);

    }
}
