package com.test.thread.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Batman on 2018/10/17.
 * @author Batman
 */
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor service = new ThreadPoolExecutor(30, 200, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1024),
                new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());

        // 等待执行的Runnable
        Runnable runnable = () -> {
            try{
                Thread.sleep(1000);
//                TimeUnit.SECONDS.sleep(3);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        };

        // 启动的任务数量
        int counts = 1024;
        for(int i=0; i<counts; i++) {
            service.execute(runnable);
        }


        // 监控线程池执行情况的代码
        while(true) {
            System.out.println();
            int queueSize = service.getQueue().size();

            System.out.println("当前排队线程数：" + queueSize);

            int activeCount = service.getActiveCount();
            System.out.println("当前活动的线程数：" + activeCount);

            long completedTaskCount = service.getCompletedTaskCount();
            System.out.println("执行完成的线程数：" + completedTaskCount);

            long taskCount = service.getTaskCount();
            System.out.println("总线程数：" + taskCount);

            try{
                Thread.sleep(3000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }

        }



    }

}

