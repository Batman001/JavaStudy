package com.test.thread.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Batman create on 2019-09-09 16:38
 * 多线程中看大夫的任务
 */
public class SeeDoctorTask implements Runnable {

    private CountDownLatch countDownLatch;

    public SeeDoctorTask(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(3000);
            System.out.println("看大夫成功，大夫给开了一些药单子.....");
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            if(countDownLatch != null) {
                countDownLatch.countDown();
            }
        }

    }
}
