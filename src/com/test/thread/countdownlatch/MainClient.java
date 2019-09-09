package com.test.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @author Batman create on 2019-09-09 16:45
 * Demo, 陪人去医院看病，轮到病人去看病的时候
 * 我去执行排队的任务准备交钱了
 */
public class MainClient {
    public static void main(String[] args) throws Exception {
        long now = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);

        Executor executor = newFixedThreadPool(2);
        executor.execute(new SeeDoctorTask(countDownLatch));
        executor.execute(new QueueTask(countDownLatch));
        countDownLatch.await();
        System.out.println("看病结束！回家！共计花费时间为" + (System.currentTimeMillis() - now));
    }
}
