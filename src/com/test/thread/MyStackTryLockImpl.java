package com.test.thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

/**
 * Created by Batman on 2018/10/19.
 */
public class MyStackTryLockImpl<T> {
    Lock lock = new ReentrantLock();
    LinkedList<T> list = new LinkedList<>();
    Condition cond = lock.newCondition();

    public void push(T obj){
        try{
            lock.lock();
            while(list.size() >= 10){
                try{
                    cond.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            list.addLast(obj);
            cond.signalAll();
        }finally {
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

    public T pull(){
        T obj = null;
        try{
            lock.lock();
            while(list.isEmpty()){
                try{
                    cond.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            obj = list.removeLast();
            cond.signalAll();
        }finally {
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            lock.unlock();
        }
        return obj;
    }

    public T peek(){
        T obj = null;
        try{
            lock.lock();
            while(list.isEmpty()){
                try{
                    cond.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            obj = list.getLast();
        }finally {
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            lock.unlock();
        }
        return obj;
    }

    public int getSize(){
        return list.size();
    }
}
