package com.test.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * Created by Batman on 2018/10/19.
 * @author Batman
 */
public class LockFuntionTest {
    public static String now(){
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static void log(String msg){
        System.out.printf("%s %s %s %n", now(), Thread.currentThread().getName(), msg);
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread t1 = new Thread(){
            @Override
            public void run(){
                try{
                    log("线程启动");
                    log("线程尝试占有对象:lock");

                    // 让线程占有对象操作
                    lock.lock();
                    log("线程占有对象:lock");
                    Thread.sleep(5000);
                    log("线程进行5秒钟业务处理");

                    log("线程临时释放对象:lock");
                    condition.await();

                    log("线程重新占有对象:lock,并进行5秒钟业务处理操作");
                    Thread.sleep(5000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                    log("线程结束");
                }

            }
        };
        t1.setName("t1");
        t1.start();

        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }

        Thread t2 = new Thread(){
            @Override
            public void run(){
                try{
                    log("线程启动");
                    log("线程尝试占有对象:lock");
                    lock.tryLock(10, TimeUnit.SECONDS);
                    log("线程占有对象:lock");

                    Thread.sleep(5000);
                    log("线程进行5秒钟业务处理操作");

                    log("唤醒等待中的线程");
                    condition.signal();


                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                    log("线程结束");
                }
            }
        };
        t2.setName("t2");
        t2.start();

    }


}
