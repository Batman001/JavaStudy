package com.test.generic;

import com.test.character.Hero;
import com.test.property.Item;
import com.test.property.LifePotion;

import java.util.LinkedList;

/**
 * Created by Batman on 2018/10/9.
 */

/**
 * MyStack 支持泛型的类
 * 设计该类的时候,在类的声明中加上<T>,表示该类支持的类型
 * @param <T> <T>T是Type的缩写,表示支持的泛型
 * @author Batman
 */
public class MyStack<T> {

    LinkedList<T> values = new LinkedList<T>();

    public static void main(String[] args) {
        //在声明这个Stack的时候，使用泛型<Hero>就表示该Stack只能放Hero
        MyStack<Hero> heroStack = new MyStack<>();
        heroStack.push(new Hero());
        //不能放Item
        //heroStack.push(new Item());

        //在声明这个Stack的时候，使用泛型<Item>就表示该Stack只能放Item
        MyStack<Item> itemStack = new MyStack<>();
        itemStack.push(new LifePotion());
        //不能放Hero
//        itemStack.push(new Hero());

    }

    public void push(T t){
        values.addLast(t);
    }

    public T pull(){
        return values.removeLast();
    }

    public T peek(){
        return values.getLast();
    }


}
