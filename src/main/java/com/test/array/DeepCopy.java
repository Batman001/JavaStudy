package com.test.array;

import java.util.ArrayList;

/**
 * <p>Java ArrayList深浅拷贝问题</p>
 *
 * @author : sunchao
 * date : 2020-07-13 10:07
 **/
public class DeepCopy {

    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i=0; i<=10; i++) {
            arrayList1.add(i);
        }

        //  将arrayList1 赋值给 arrayList2
        ArrayList<Integer> arrayList2 = arrayList1;

        // 删除arrayList2 索引为9 位置的元素
        arrayList2.remove(9);

        // 打印发现出现arrayList1、arrayList2 同时发生了变化\
        System.out.println("直接赋值方法导致元素会同时发生变化....");
        System.out.println(arrayList1.toString());
        System.out.println(arrayList2.toString());


        // 方法一：ArrayList<Integer> b= new ArrayList<Integer>(a);//利用集合自带的构造方法
        // 方法二：ArrayList<Integer> b = (ArrayList<Integer>) a.clone();//利用克隆的方法进行赋值。

        ArrayList<Integer> arrayList3 = new ArrayList<Integer>(arrayList1);

        arrayList3.remove(8);

        System.out.println("方法一：使用集合自带的构造方法赋值..........");
        System.out.println(arrayList1.toString());
        System.out.println(arrayList2.toString());
        System.out.println(arrayList3.toString());


        ArrayList<Integer> arrayList4 = (ArrayList<Integer>) arrayList1.clone();

        arrayList4.remove(0);

        System.out.println("方法二：利用克隆的方法进行赋值..........");
        System.out.println(arrayList1.toString());
        System.out.println(arrayList2.toString());
        System.out.println(arrayList4.toString());



    }
}
