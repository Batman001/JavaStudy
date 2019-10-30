package com.test.thread;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Batman on 2018/10/10.
 * @author Batman
 */
public class ThreadFuncTest {


    public static void main(String[] args) {
//        Thread t1 = new Thread(){
//            @Override
//            public void run(){
//                int seconds = 0;
//                while(true){
//                    try{
//                        Thread.sleep(1000);
//                    }
//                    catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                    System.out.printf("已经玩游戏 %d 秒%n",seconds ++);
//
//                }
//            }
//        };
//        t1.start();

        final MyHero gareen = new MyHero();
        gareen.name = "盖伦";
        gareen.hp = new AtomicInteger(616);
        gareen.damage = 50;

        final MyHero teemo = new MyHero();
        teemo.name = "提莫";
        teemo.hp = new AtomicInteger(300);
        teemo.damage = 30;

        final MyHero bh = new MyHero();
        bh.name = "赏金猎人";
        bh.hp = new AtomicInteger(500);
        bh.damage = 65;

        final MyHero leesin = new MyHero();
        leesin.name = "盲僧";
        leesin.hp = new AtomicInteger(415);
        leesin.damage = 80;

        Thread t1 = new Thread(){
            @Override
            public void run(){
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }
            }

        };
//        t1.start();
        //代码执行到这里，一直是main线程在运行

//        try{
//            //t1线程加入到main线程中来，只有t1线程运行结束，才会继续往下走
//            t1.join();
//        }
//        catch(InterruptedException e){
//            e.printStackTrace();
//        }

        Thread t2 = new Thread(){
            @Override
            public void run(){
                while(!leesin.isDead()){
                    // 临时暂停,使得t1可以占用CPU资源
                    Thread.yield();
                    bh.attackHero(leesin);

                }
            }
        };
//        t2.start();

        // 线程优先级设置
//        t1.setPriority(5);
//        t2.setPriority(Thread.MAX_PRIORITY);
//        t1.start();
//        t2.start();

        // 守护线程
        Thread t3 = new Thread(){
            @Override
            public void run(){
                int seconds = 0;
                while(true){
                    try{
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.printf("已经玩游记时间为%d秒", seconds++);
                }

            }

        };
        // 如果一个多线程任务重只有守护线程,结束当前进程
        t3.setDaemon(true);
        t3.start();

    }
}
