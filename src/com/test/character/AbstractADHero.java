package com.company.caini.character;

/**
 * Created on 2018/7/2.
 * @author Batman
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
