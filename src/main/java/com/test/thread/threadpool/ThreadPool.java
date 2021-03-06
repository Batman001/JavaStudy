package com.test.thread.threadpool;

import java.util.LinkedList;

/**
 * Created by Batman on 2018/10/17.
 * @author Batman
 */
public class ThreadPool {
    /**
     * 线程池大小
     */
    private int threadPoolSize;

    /**
     * 任务容器
     */
    private final LinkedList<Runnable> tasks = new LinkedList<>();

    ThreadPool(){
        this.threadPoolSize = 10;
        synchronized (tasks){
            for(int i=0; i<threadPoolSize; i++){
                new ConsumerThread("消费者线程" + i).start();
            }
        }
    }

    public void add(Runnable r){
        synchronized (tasks){
            tasks.add(r);
            tasks.notifyAll();
        }


    }
    class ConsumerThread extends Thread{

        ConsumerThread(String name){
            super(name);
        }

        @Override
        public void run(){
            System.out.println("启动线程:" + this.getName());
            while(true){
                synchronized (tasks){
                    while(tasks.isEmpty()){
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    tasks.removeLast();
                    tasks.notifyAll();
                }
                System.out.println(this.getName() + "获取到任务,并执行");
//                task.run();
            }

        }

    }

}
