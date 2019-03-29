package com.company.caini.collection;

import com.company.caini.character.Hero;

import java.util.LinkedList;

/**
 * Created by Batman on 2018/8/1.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        // LinkedList是一个双向链表结构的list
        LinkedList<Hero> l1 = new LinkedList<Hero>();

        // 可以很方便在头部或者尾部插入数据
        l1.addLast(new Hero("赵云", 178.f));
        l1.addLast(new Hero("程咬金",230.f));
        l1.addLast(new Hero("露娜", 134.f));
        System.out.println(l1);


        // 在最前面插入新的英雄
        l1.addFirst(new Hero("扁鹊", 120.f));

        System.out.println(l1);

        // 查看最前面的英雄
        System.out.println("最前面的英雄是" + l1.getFirst());
        // 查看最后面的英雄
        System.out.println("最后面的英雄是"+l1.getLast());

        // 取出最前面英雄
        System.out.println(l1.removeFirst());
        // 取出最后面英雄
        System.out.println(l1.removeLast());

        System.out.println(l1);
    }
}
