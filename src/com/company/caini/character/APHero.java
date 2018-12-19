package com.company.caini.character;

import com.company.caini.property.Mortal;

/**
 * Created by sunchao on 2018/6/28.
 */
public class APHero extends Hero implements AP,Mortal{
    public APHero(String heroName, float heroHp) {
        super(heroName, heroHp);
    }


    @Override
    public void magicAttack() {

    }
    @Override
    public void die(){
        System.out.println(this.name+"我一个法师角色可以加血 牛逼牛逼  你杀不死我");
    }
}
