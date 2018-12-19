package com.company.caini.thread;

/**
 * Created by sunchao on 2018/10/17.
 * @author sunchao
 */
public class ProducerConsumerTest {
    public static class ProduceThread extends Thread {
        private MySafeStack<Character> stack;
        public ProduceThread(MySafeStack<Character> stack, String name) {
            super(name);
            this.stack = stack;
        }
        @Override
        public void run(){
            while(true){
                char c = randomChar();
                System.out.println(this.getName() + " 压入" + c);
                stack.push(c);
                System.out.println("压入字符后,栈的空间为: "+stack.size());

                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
        public char randomChar(){
            return (char)(Math.random() * ('Z' + 1 - 'A') + 'A');
        }
    }
    public static class ConsumerThread extends Thread{
        private MySafeStack<Character> stack;

        public ConsumerThread(MySafeStack<Character> stack, String name){
            super(name);
            this.stack = stack;
        }
        @Override
        public void run(){
            while(true){
                char c = stack.pull();
                System.out.println(this.getName() + " 弹出" + c);
                System.out.println("弹出该字符后,栈的空间为: "+stack.size());
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

    }
    public static void main(String[] args) {
        MySafeStack<Character> stack = new MySafeStack<>();
//        ProducerConsumerTest pct = new ProducerConsumerTest();
        new ProduceThread(stack,"producer1").start();
        new ProduceThread(stack,"producer2").start();
        new ConsumerThread(stack,"consumer1").start();
//        new ConsumerThread(stack,"consumer2").start();
//        new ConsumerThread(stack,"consumer3").start();

    }
}
