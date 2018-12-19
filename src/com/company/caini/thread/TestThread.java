package com.company.caini.thread;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunchao on 2018/10/9.
 * @author sunchao
 */
public class TestThread {

    public static void main(String[] args) {

        MyHero gareen = new MyHero();
        gareen.name = "盖伦";
        gareen.hp = new AtomicInteger(616);
        gareen.damage = 50;

        MyHero teemo = new MyHero();
        teemo.name = "提莫";
        teemo.hp = new AtomicInteger(300);
        teemo.damage = 30;

        MyHero bh = new MyHero();
        bh.name = "赏金猎人";
        bh.hp =new AtomicInteger(500);
        bh.damage = 65;

        MyHero leesin = new MyHero();
        leesin.name = "盲僧";
        leesin.hp = new AtomicInteger(455);
        leesin.damage = 80;

//        //盖伦攻击提莫
//        while(!teemo.isDead()){
//            gareen.attackHero(teemo);
//        }
//
//        //赏金猎人攻击盲僧
//        while(!leesin.isDead()){
//            bh.attackHero(leesin);
//        }

        KillThread kt = new KillThread(gareen, teemo);
        kt.start();
        KillThread kt2 = new KillThread(bh, leesin);
        kt2.start();

        Battle bt1 = new Battle(gareen, teemo);
        new Thread(bt1).start();

        Battle bt2 = new Battle(bh, leesin);
        new Thread(bt2).start();

        // 匿名类测试多线程
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }
        };

        t1.start();

        Thread t2 = new Thread(){
            @Override
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }
            }
        };

        t2.start();


    }

}

