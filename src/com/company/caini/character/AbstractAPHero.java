package com.company.caini.character;

/**
 * Created on 2018/7/2.
 * @author Batman
 */
public class AbstractAPHero extends AbstractHero {

    @Override
    public void attack() {
        magicAttack();
    }

    public void magicAttack(){
        System.out.println("进行魔法攻击");
    }


}
