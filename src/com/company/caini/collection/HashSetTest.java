package com.company.caini.collection;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by sunchao on 2018/8/2.
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> names = new HashSet<>();
        names.add("Gareen");
        System.out.println(names);

        // 第二次插入同样的数据,是插不进去的,容器只会保留一个数据
        names.add("Gareen");
        System.out.println(names);

        names.add("Teemo");
        names.add("Tank");
        names.add("Shooter");

        // HashSet中的数据是没有顺序的
        System.out.println(names);

//        HashSet中不提供get方法获取指定位置的元素,遍历需要用到迭代器,或者增强型for循环

        HashSet<Integer> numbers = new HashSet<>();
        for(int i=0;i<10;i++){
            numbers.add(i);
        }

//        遍历set可以采用迭代器iterator
        for(Iterator<Integer> it = numbers.iterator(); it.hasNext();){
            Integer i = it.next();
            System.out.println(i);
        }


//        使用增强型for循环遍历HashSet
        for(Integer i : numbers){
            System.out.println(i);
        }


        // 不重复的随机数
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<50;i++){
            hs.add((int)(Math.random() * 10000));
        }
        System.out.println("生成随机的50个不重复的数为:");
        for(int i : hs){
            System.out.println(i);
        }
    }


}
