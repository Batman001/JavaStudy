package com.company.caini.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Batman on 2018/10/17.
 * @author Batman
 */
public class ThreadPoolJavaCarryTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 15, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        threadPool.execute(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("线程池执行任务" + (i+1));
                }
            }
        });


    }

}

