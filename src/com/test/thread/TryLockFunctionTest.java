package com.company.caini.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Batman on 2018/10/19.
 * @author Batman
 */
public class TryLockFunctionTest {

    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg){
        System.out.printf("%s %s %s %n",now(), Thread.currentThread().getName(), msg);
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                try{
                    log("线程启动");
                    log("线程试图占有对象:lock");
                    lock.lock();

                    log("占有对象:lock");
                    log("进行5秒的业务操作");
                    Thread.sleep(5000);
                    log("临时释放对象lock,并等待");
                    condition.await();
                    log("重新占有对象lock,并进行5秒的业务操作");
                    Thread.sleep(5000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    log("释放对象:lock");
                    lock.unlock();
                }
                log("线程结束");
            }
        };
        t1.setName("t1");
        t1.start();
        try{
            //先让t1飞2秒
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        Thread t2 = new Thread(){
            @Override
            public void run(){
                try{
                    log("线程启动");
                    log("线程试图占有对象:lock");

                    lock.lock();
                    log("占有对象:lock");
                    log("进行5秒的业务操作");
                    Thread.sleep(5000);
                    log("唤醒等待中的线程");
                    condition.signal();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    log("释放对象:lock");
                    lock.unlock();
                }
                log("线程结束");

            }
        };
        t2.setName("t2");
        t2.start();

    }

}
