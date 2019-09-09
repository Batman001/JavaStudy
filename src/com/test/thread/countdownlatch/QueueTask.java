package com.test.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Batman create on 2019-09-09 16:42
 */
public class QueueTask implements Runnable {

    private CountDownLatch countDownLatch;

    public QueueTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(5000);
            System.out.println("排队成功，可以进行交费了...");
        } catch(InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
