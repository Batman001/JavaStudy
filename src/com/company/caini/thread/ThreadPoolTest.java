package com.company.caini.thread;

/**
 * Created by sunchao on 2018/10/17.
 * @author sunchao
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();

        int sleep = 1000;
        while(true){
            pool.add(new Runnable() {
                @Override
                public void run() {
                    try{
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("执行任务!");
                }
            });
            try{
                Thread.sleep(sleep);
                sleep = sleep > 100 ? sleep-100:sleep;

            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }

    }

}
