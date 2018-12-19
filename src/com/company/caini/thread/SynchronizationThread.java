package com.company.caini.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunchao on 2018/10/12.
 * @author sunchao
 */
public class SynchronizationThread {


    public static void main(String[] args) {

        final MyHero gareen = new MyHero("盖伦", new AtomicInteger(10000), 1);

        int n = 1000;
        Thread[] addThreads = new Thread[n];
        Thread[] reduceThreads = new Thread[n];

        // n个线程增加盖伦血量
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    gareen.recover();
                    System.out.println("当前操作增加血量" + gareen.hp);
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t.start();
            addThreads[i] = t;
        }

        // n个线程减少盖伦血量
        for (int i = 0; i < n; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    gareen.hurt();
                    System.out.println("当前操作减少血量" + gareen.hp);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            };
            t.start();
            reduceThreads[i] = t;
        }


        // 等待所有增加线程结束
        for(Thread t:addThreads){
            try{
                t.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        // 等待所有减少线程结束
        for(Thread t:reduceThreads){
            try{
                t.join();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.printf("%d个增加线程和%d个减少线程结束后%n盖伦的血量变成了 %.0f%n",n,n,gareen.hp);
    }
}
