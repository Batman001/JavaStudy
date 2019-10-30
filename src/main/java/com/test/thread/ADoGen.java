package com.test.thread;

/**
 * Created by Batman on 2018/10/10.
 * @author Batman
 */
public class ADoGen implements Runnable {
    public static void main(String[] args) {
        ADoGen adg = new ADoGen();
        new Thread(adg).start();

    }
    @Override
    public void run(){
        while(true){
            for(int i=0;i<3;i++){
                System.out.printf("a-do-gen 发动第 %d 次攻击%n", i+1);
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            try{
                System.out.printf("cd in 5s 进行蓄能中%n");
                Thread.sleep(5000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }



}
