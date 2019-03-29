package com.company.caini.thread;

/**
 * Created by Batman on 2018/10/19.
 * @author Batman
 */
public class ProducerConsumerLockTest {
    public static class Cons extends Thread{
        private MyStackTryLockImpl<Integer> list;
        private String name;
        private Object lock;

        public Cons(MyStackTryLockImpl<Integer> list, Object lock, String name){
            this.list = list;
            this.lock = lock;
            this.name = name;
        }

        @Override
        public void run(){
            while(true){
                int a = list.pull();
                System.out.println(name + " 弹出数据" +a);
                System.out.printf("弹出数据后的,栈的大小为%d%n",list.getSize());
            }
        }

    }

    public static class Prod extends Thread{
        private MyStackTryLockImpl list;
        private String name;
        private Object lock;

        public Prod(MyStackTryLockImpl list, Object lock,String name ){
            this.list = list;
            this.lock = lock;
            this.name = name;
        }

        @Override
        public void run(){
            while(true){
                int a = (int)(Math.random() * 10);
                list.push(a);
                System.out.println(name + " 压入数据" + a);
                System.out.printf("压入数据后的,栈的大小为%d%n",list.getSize());

            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        MyStackTryLockImpl<Integer> list = new MyStackTryLockImpl<>();
        new Prod(list, lock, "生产者1").start();
        new Prod(list, lock, "生产者2").start();
        new Prod(list, lock, "生产者3").start();

        new Cons(list, lock, "消费者1").start();
        new Cons(list, lock, "消费者2").start();

    }

}
