package com.company.caini.thread;

/**
 * Created by sunchao on 2018/10/15.
 * @author sunchao
 */
public class DeadLock {

    public static void main(String args[])
    {
        final Object shuitong= new Object();
        final Object shuipiao = new Object();
        final Object shuibei = new Object();
        Thread t1 = new Thread(){
            @Override
            public void run()
            {
                synchronized (shuitong) {
                    System.out.println("线程t1已经占有水桶资源");
                    //等待1000毫秒，确保线程二能够获得水瓢资源。
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                    System.out.println("t1尝试获取水瓢资源");
                    System.out.println("t1等待中。。。");
                    synchronized (shuipiao) {
                        System.out.println("t1成功获取水瓢资源");
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run()
            {
                synchronized (shuipiao) {
                    System.out.println("线程t2已经占有水瓢资源");
                    //等待1000毫秒，确保线程三能够获得水杯资源。
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                    System.out.println("t2尝试获取水杯资源");
                    System.out.println("t2等待中。。。");
                    synchronized (shuibei) {
                        System.out.println("t2成功获取水杯资源");
                    }
                }
            }
        };
        t2.start();

        Thread t3 = new Thread(){
            @Override
            public void run()
            {
                synchronized (shuibei) {
                    System.out.println("线程t3已经占有水杯资源");
                    //这里线程t1已经获取水桶资源，所以不需要再让线程t3等待
                    System.out.println("t3尝试获取水桶资源");
                    System.out.println("t3等待中。。。");
                    synchronized (shuitong) {
                        System.out.println("t3成功获取水桶资源");
                    }
                }
            }
        };
        t3.start();
    }
}