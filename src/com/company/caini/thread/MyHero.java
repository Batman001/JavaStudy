package com.company.caini.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunchao on 2018/10/9.
 * @author:sunchao
 */

public class MyHero{
    public String name;
    public AtomicInteger hp = new AtomicInteger();

    public int damage;

    public MyHero(String name, AtomicInteger hp, int damage){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
    public MyHero(){}
    public MyHero(String heroName){
        this.name = heroName;
    }


    /**
     * 回血操作
     */
    public synchronized void recover(){
        if(hp.intValue() == 1000){
            try{
                this.wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        hp.incrementAndGet();
        System.out.printf("%s 回血1点,增加血后，%s的血量是%.0f%n", name, name, hp);
        // 通知那些等待在this对象上的线程，可以醒过来了，如第20行，等待着的减血线程，苏醒过来
        this.notify();
    }

    /**
     * 掉血操作
     */
    public synchronized void hurt(){
        if(hp.intValue()==1){
            try{
                // 让占有this的减血线程，暂时释放对this的占有，并等待
                this.wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        hp.decrementAndGet();
        System.out.printf("%s 减血1点,减少血后，%s的血量是%.0f%n", name, name, hp);
        this.notify();
    }

    public String getName(){
        return this.name;
    }

    public void attackHero(MyHero mh){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        mh.hp.addAndGet(0-damage);

        System.out.printf("%s 正在攻击 %s, %s的血量变成 %.0f%n", name, mh.name, mh.name, mh.hp);

        if(mh.isDead())
            System.out.println(mh.name + "死了!");
    }


    public boolean isDead() {
        return 0>=hp.intValue()?true:false;
    }

}

