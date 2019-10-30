package com.test.designpattern.prototype;

import java.util.ArrayList;

/**
 * @author Batman create on 2019-04-23 14:48
 * 客户端类
 * 深浅复制区别在于:对于对象内部所有引用型对象的复制结果
 */
public class Client {
    public static void main(String[] args) {
        Prototype cp = new Prototype();
        cp.setmInt(10);
        ArrayList<String> list = new ArrayList<>();
        list.add("原型模式");
        cp.setList(list);
        Prototype protoClone = (Prototype) cp.clone();
        System.out.println("浅复制前的内容：");
        System.out.println("mInt:" + protoClone.getmInt());
        System.out.println("list:" + protoClone.getList());

        cp.setmInt(20);
        list.add("浅复制clone后的原型模式");
        cp.setList(list);
        System.out.println("浅复制后内容：");
        System.out.println("mInt:" + protoClone.getmInt());
        System.out.println("list:" + protoClone.getList());


        PrototypeDeep cpDeep = new PrototypeDeep();
        cpDeep.setmInt(100);
        ArrayList<String> deepList = new ArrayList<>();
        deepList.add("原型模式");
        cpDeep.setList(deepList);
        System.out.println("深复制1前的内容为：");
        System.out.println("mInt:" + cpDeep.getmInt());
        System.out.println("list:" + cpDeep.getList());
        PrototypeDeep protoDeepClone = cpDeep.clone();

        /**
         * 被复制的内容属性发生变化
         */
        cpDeep.setmInt(1000);
        deepList.add("深复制1clone后的原型模式");
        cpDeep.setList(deepList);

        System.out.println("深复制1后的内容为：");
        System.out.println("mInt:" + protoDeepClone.getmInt());
        System.out.println("list:" + protoDeepClone.getList());




        PrototypeDeepBySerial cpDeep2 = new PrototypeDeepBySerial();
        cpDeep2.setmInt(99);
        ArrayList<String> deepList2 = new ArrayList<>();
        deepList2.add("原型模式");
        cpDeep2.setList(deepList2);
        System.out.println("深复制2前的内容为：");
        System.out.println("mInt:" + cpDeep2.getmInt());
        System.out.println("list:" + cpDeep2.getList());
        PrototypeDeepBySerial protoDeepClone2 = cpDeep2.deepClone();

        /**
         * 被复制的内容属性发生变化
         */
        cpDeep2.setmInt(1000);
        deepList2.add("深复制2clone后的原型模式");
        cpDeep2.setList(deepList);

        System.out.println("深复制2后的内容为：");
        System.out.println("mInt:" + protoDeepClone2.getmInt());
        System.out.println("list:" + protoDeepClone2.getList());

    }

}
/**
 *
 */
