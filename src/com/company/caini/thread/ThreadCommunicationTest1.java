package com.company.caini.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Batman on 2018/10/15.
 * @author Batman
 * 使用wait和notify进行线程交互
 */
public class ThreadCommunicationTest1 {

    public static void main(String[] args) {
        final MyHero teemo = new MyHero("teemo", new AtomicInteger(616), 1);
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while(true){
                    teemo.hurt();
                    try{
                        Thread.sleep(100);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }

        };
        t1.start();

        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    teemo.recover();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t2.start();

    }
}
