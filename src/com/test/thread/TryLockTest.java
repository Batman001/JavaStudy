package com.company.caini.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * Created by Batman on 2018/10/19.
 * @author Batman
 */
public class TryLockTest {

    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg){
        System.out.printf("%s %s %s %n",now(), Thread.currentThread().getName(), msg);

    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(){
            @Override
            public void run(){
                boolean locked = false;
                try{
                    log("线程启动");
                    log("试图占有对象:lock");

                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if(locked){
                        log("占有对象:lock");
                        log("进行5秒的业务处理");
                        Thread.sleep(5000);
                    }
                    else{
                        log("经过1秒钟的努力,还么有占有对象,放弃占有");
                    }
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    if(locked){
                        log("释放对象:lock");
                        lock.unlock();
                    }
                }
                log("线程结束");
            }
        };
        t1.setName("t1");
        t1.start();

        try{
            // 先让t1飞2秒
            Thread.sleep(2000);
        }
        catch(InterruptedException e1){
            e1.printStackTrace();
        }

        Thread t2 = new Thread(){
            @Override
            public void run(){
                boolean locked = false;
                try {
                    log("线程启动");
                    log("试图占有对象:lock");
                    locked = lock.tryLock(1, TimeUnit.SECONDS);
                    if(locked){
                        log("占有对象:lock");
                        log("进行5秒的业务操作");
                        Thread.sleep(5000);
                    }
                    else{
                        log("经过1秒钟努力,没有占有对象,放弃占有");
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if(locked){
                        log("释放对象:lock");
                        lock.unlock();
                    }
                }
                log("线程结束");

            }

        };
        t2.setName("t2");
        t2.start();
    }


}
