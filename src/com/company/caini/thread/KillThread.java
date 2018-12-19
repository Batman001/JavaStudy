package com.company.caini.thread;

/**
 * Created by sunchao on 2018/10/9.
 * @author Batman
 */
public class KillThread extends Thread {
    private MyHero attack;
    private MyHero bear;

    public KillThread(MyHero mh1, MyHero mh2){
        this.attack = mh1;
        this.bear = mh2;
    }

    @Override
    public void run(){
        while(!bear.isDead()){
            attack.attackHero(bear);
        }
    }

}
