package com.company.caini.character;

/**
 * Created by sunchao on 2018/7/2.
 * @author sunchao
 */
public class AbstractADAPHero extends AbstractHero {

    @Override
    public void attack() {
        System.out.println("既然可以进行物理攻击，也可以进行魔法攻击");
    }

    public void magicAttack(){
        System.out.println("进行魔法攻击");
    }

    public void physicalAttack(){
        System.out.println("进行物理攻击");
    }
}
