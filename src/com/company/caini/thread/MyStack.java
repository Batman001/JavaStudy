package com.company.caini.thread;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sunchao on 2018/10/15.
 * @author sunchao
 */
public class MyStack {
    /**
     * 把LinkedList通过collection的synchronized方法转换成一个线程安全的List
     */
    List<MyHero> heros = (List<MyHero>) Collections.synchronizedList(new LinkedList<MyHero>());


    public void push(MyHero h){
        heros.add(h);
    }

    public MyHero pull(){
        return heros.remove(heros.size() - 1);
    }

    public MyHero peek(){
        return heros.get(heros.size() - 1);
    }

    @Override
    public String toString(){
        return "MyStack [List=" + heros + "]";
    }

    public static void main(String[] args) {
        int n = 100;
        final MyStack heroStack = new MyStack();
        Thread[] threads = new Thread[n];
        Thread[] threads1 = new Thread[n];
        for(int i=0;i<n;i++){
            final MyHero h = new MyHero("Hero name" + i);
            System.out.println("压入Hero " + h.getName());
            Thread t = new Thread(){
                @Override
                public void run(){
                    heroStack.push(h);
                }
            };
            t.start();
            threads[i] = t;
        }

        for(int i=0;i<n;i++){
            Thread t = new Thread(){
                @Override
                public void run(){
                    MyHero h = heroStack.pull();
                    System.out.println("弹出Hero " + h.getName());
                }
            };
            t.start();
            threads1[i] = t;
        }

        for(Thread t:threads){
            try{
                t.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        for(Thread t:threads1){
            try{
                t.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }


        System.out.println(heroStack);
    }
}
