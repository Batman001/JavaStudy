package com.test.generic;

import com.test.character.APHero;
import com.test.character.Hero;

import java.util.ArrayList;

/**
 * Created by Batman on 2018/10/9.
 */
public class TestGeneric {

    public static void iterate(ArrayList<? extends Hero> list){
        for(Hero hero : list){
            System.out.println(hero.getName());
        }
    }
    public static void main(String[] args){
        ArrayList<APHero> heros = new ArrayList<>();
//        只有APHero可以放进去f
        heros.add(new APHero("扁鹊", 400.f));

//        ADHero是没有办法放进去的
//        heros.add(new ADHero("后裔",230.f));

//        获取容器内元素的时候也不需要转型,因为取出来一定是APHero
        APHero ap = heros.get(0);
        System.out.println(ap.name);

        ArrayList<Number> ai = new ArrayList<>();
        ai.add(10);
        ai.add(100.89);

        System.out.println(ai.get(0));
        System.out.println(ai.get(1));


        ArrayList<APHero> apHeroList = new ArrayList<APHero>();
        apHeroList.add(new APHero("王昭君", 120.f));

        ArrayList<? extends Hero> heroList = apHeroList;

        //? extends Hero 表示这是一个Hero泛型的子类泛型

        //heroList 的泛型可以是Hero
        //heroList 的泛型可以使APHero
        //heroList 的泛型可以使ADHero

        //可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的

        Hero h= heroList.get(0);
        System.out.println(h.getName());

        //但是，不能往里面放东西
//        heroList.add(new ADHero("狄仁杰", 120.f)); //编译错误，因为heroList的泛型 有可能是APHero

        iterate(heroList);
        iterate(heros);


        /**
         * 子类泛型能否转成父类泛型
         */

        Hero h1 = new Hero();
        APHero ap1 = new APHero("安琪拉", 120.f);
        // 对象中子类转父类可以的
        h1 = ap1;


        ArrayList<Hero> hs = new ArrayList<>();
        ArrayList<APHero> aps = new ArrayList<>();
//        子类泛型转父类泛型 不可以
//        hs = aps;
//        父类泛型转子类泛型 不可以
//        aps = hs;


    }
}

