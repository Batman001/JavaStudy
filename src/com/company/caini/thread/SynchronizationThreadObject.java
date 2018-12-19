package com.company.caini.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sunchao on 2018/10/12.
 * @author sunchao
 */
public class SynchronizationThreadObject {
    public static void main(String[] args) {
        final Object someObject = new Object();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try{
                    System.out.println(now() + " t1线程已经运行");
                    System.out.println(now() + " "+ this.getName() + " 试图占用Object:SomeObject");
                    synchronized(someObject){
                        System.out.println(now()+" "+this.getName() + " 试图占用对象:SomeObject");
                        Thread.sleep(5000);
                        System.out.println("当前线程 "+ this.getName()+ "睡眠5000毫秒");
                        System.out.println(now() + " "+this.getName() + " 释放对象:SomeObject");
                    }
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(){
            @Override
            public void run(){
                try{
                    System.out.println(now() + " t2线程已经运行");
                    System.out.println(now() + " "+ this.getName() + " 试图占用对象:SomeObject");
                    synchronized(someObject){
                        System.out.println(now() + " " + this.getName() + " 试图占用对象:SomeObject");
                        Thread.sleep(5000);
                        System.out.println(now() + " "+this.getName() + " 试图占用对象:SomeObject");

                    }

                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        t2.setName("t2");
        t2.start();
    }

    private static String now() {
        return new  SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    }