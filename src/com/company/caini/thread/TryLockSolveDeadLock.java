package com.company.caini.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * Created by sunchao on 2018/10/19.
 * @author Batman
 */
public class TryLockSolveDeadLock {

    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
    public static void log(String msg){
        System.out.printf("%s %s %s %n", now(), Thread.currentThread().getName(), msg);
    }

    public static void main(String[] args) throws InterruptedException{
        Lock lock_ahri = new ReentrantLock();
        Lock lock_annie = new ReentrantLock();

        Thread t1 = new Thread(){
            @Override
            public void run(){
                boolean ahriLocked = false;
                boolean annieLocked = false;
                try{
                    log("线程已经启动");
                    ahriLocked = lock_ahri.tryLock(10, TimeUnit.SECONDS);
                    if(ahriLocked){
                        log("已经占有对象九尾妖狐");
                    }
                    Thread.sleep(1000);
                    try{
                        log("线程试图占有对象安妮对象");
                        annieLocked = lock_annie.tryLock(10, TimeUnit.SECONDS);
                        if(annieLocked){
                            log("线程成功占有对象安妮,开始啪啪啪");
                        }
                        else{
                            log("线程老是占有不了对象安妮,选择放弃");
                        }
                    }finally {
                        if(annieLocked){
                            log("线程释放对象安妮");
                            lock_annie.unlock();
                        }

                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if(ahriLocked){
                        log("线程释放对象九尾妖狐");
                        lock_ahri.unlock();
                    }
                }

            }
        };
        t1.setName("t1");
        t1.start();

        Thread.sleep(100);

        Thread t2 = new Thread(){
            @Override
            public void run(){
                boolean ahriLocked = false;
                boolean annieLocked = false;

                try{
                    log("线程已经启动");
                    annieLocked = lock_annie.tryLock(10, TimeUnit.SECONDS);
                    if(annieLocked){
                        log("线程已经占有对象安妮");
                        Thread.sleep(900);
                        log("线程试图占有对象九尾妖狐");
                        try{
                            ahriLocked = lock_ahri.tryLock(10, TimeUnit.SECONDS);
                            if (ahriLocked){
                                log("线程成功占有对象九尾妖狐,开始啪啪啪");
                            }
                            else{
                                log("线程老是占有不了对象九尾妖狐,选择放弃");
                            }
                        }finally {
                            if(ahriLocked){
                                log("线程释放对象九尾妖狐");
                                lock_ahri.unlock();
                            }
                        }

                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if(annieLocked){
                        log("线程释放对象安妮");
                        lock_annie.unlock();
                    }
                }

            }
        };
        t2.setName("t2");
        t2.start();
    }

}
