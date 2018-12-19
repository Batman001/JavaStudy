package com.company.caini.character;

/**
 * Created by sunchao on 2018/7/2.
 * @author sunchao
 */
public class AbstractADHero extends AbstractHero {


    public void physicalAttack(){
        System.out.println("进行物理攻击");
    }
    @Override
    public void attack() {
        physicalAttack();
    }
}
