package com.test.collection;


import com.test.character.Hero;

import java.util.LinkedList;



/**
 * Created by Batman on 2018/8/1.
 */
public class MyStack implements Stack {

    LinkedList<Hero> heros = new LinkedList<>();


    @Override
    public void push(Hero h) {
        heros.addLast(h);
        System.out.println("栈中添加进一个英雄" + h);
    }

    @Override
    public Hero pull() {
        if(heros.isEmpty()){
            System.out.println("栈为空");
            return null;
        }
        else{
            System.out.println("pull()操作的对象是:"+heros.getLast());
            return heros.removeLast();
        }

    }

    @Override
    public Hero peek() {
        if(heros.isEmpty()){
            System.out.println("栈为空");
            return null;
        }
        else{
            System.out.println("peek()操作的对象是:"+heros.getLast());
            return heros.getLast();
        }
    }


    public void display(){
        for (Hero each : heros){
            System.out.println(each);
        }
    }

    public static void main(String[] args) {

        MyStack ms = new MyStack();
        for(int i=0;i<10;i++){
            ms.push(new Hero("Hero "+i, 100.f));
        }

        System.out.println("创建好的空栈内容是:\t");
        ms.display();

        ms.pull();

        System.out.println("经过pull()操作后的栈的内容是:\t");
        ms.display();

        ms.peek();
        System.out.println("经过peek()操作后的栈的内容是:\t");
        ms.display();


    }
}
