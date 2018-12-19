package com.company.caini.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunchao on 2018/10/15.
 * @author sunchao
 * 大量占用CPU,拖慢性能
 */
public class ThreadCommunicationTest {

    public static void main(String[] args) {
        final MyHero gareen = new MyHero("gareen", new AtomicInteger(616), 1);
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while(true) {
                    while (gareen.hp.intValue()== 1) {
                        continue;
                    }
                    gareen.hurt();
                    System.out.printf("t1 为%s 减血1点,减少血后，%s的血量是%.0f%n",
                            gareen.name,gareen.name,gareen.hp);
                    try{
                        Thread.sleep(10);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }

                }

            }

        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run(){
                while(true){
                    gareen.recover();
                    System.out.printf("t2 为%s 回血1点,增加血后，%s的血量是%.0f%n",
                            gareen.name,gareen.name,gareen.hp);
                    try{
                        Thread.sleep(100);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }

            }
        };
        t2.start();
    }
}
