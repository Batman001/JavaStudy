package com.test.threadlocal;

/**
 * @author Batman create on 2019-09-20 16:28
 */
public class ThreadLocalDemo {
    private static final ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        @Override
        public Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        for(int i=0; i < 5; i++) {
            new Thread(new MyThread(i)).start();

        }
    }

    static class MyThread implements Runnable {
        private int index;

        public MyThread(int index) {
            this.index = index;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            System.out.println("线程" + index + "初始的value：" + value.get());

            for(int i=0; i<10; i++) {
                value.set(value.get() + i);
            }

            System.out.println("线程" + index + "的累加value:" + value.get());
        }
    }

}
