package com.test.character;

import com.test.property.Mortal;

/**
 * Created on 2018/6/28.
 * @author Batman
 */
public class ADAPHero extends Hero implements AD,AP,Mortal {

    public ADAPHero(String heroName, float heroHp, float heroArmor, int heroMoveSpeed) {
        super(heroName, heroHp, heroArmor, heroMoveSpeed);
    }

    public ADAPHero(){}

    @Override
    public void physicalAttack() {

    }

    @Override
    public void magicAttack() {

    }

    @Override
    public void die(){
        System.out.println(this.name + "即使作为一个射手属性和法师属性的角色,可是我还是会死");
    }

    @Override
    public void attack(){
        System.out.println("这是"+name+"ADAP的攻击手段,通过调用ADAP接口来实现");
    }




}

