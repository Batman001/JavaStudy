package com.test.collection;

import com.test.character.Hero;

import java.util.Queue;
import java.util.LinkedList;

import java.util.List;


/**
 * Created by Batman on 2018/8/1.
 */
public class QueueTest {
    public static void main(String[] args) {
        // LinkedList 实现了List的接口
        List l1 = new LinkedList<Hero>();

        // LinkedList实现了Deque,进而实现了Queue的接口
        // Queue代表了FIFO, 先进先出队列
        Queue<Hero> q = new LinkedList<>();

        // 加载队列的最后面
        System.out.println("初始化队列: \t");
        q.offer(new Hero("hero 1", 100.f));
        q.offer(new Hero("hero 2", 100.f));
        q.offer(new Hero("hero 3", 100.f));
        q.offer(new Hero("hero 4", 100.f));

        for(Hero h : q){
            System.out.println(h);
        }

        // 取出第一个Hero,FIFO先进先出
        Hero hero = q.poll();
        System.out.println("取出一个元素后的队列为:\t");
        for(Hero h : q){
            System.out.println(h);
        }

        // 把第一个元素拿出来看一看,但不取出来
        hero = q.peek();
        System.out.println("查看peek()的第一个元素:\t");
        System.out.println(hero);
        System.out.println("peek()操作不会把元素取出来\t");
        System.out.println("打印peek()操作后的队列元素为:\t");
        for(Hero h : q)
            System.out.println(h);


    }
}
