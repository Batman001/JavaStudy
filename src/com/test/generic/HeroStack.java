package com.company.caini.generic;

import com.company.caini.character.Hero;

import java.util.LinkedList;

/**
 * Created by Batman on 2018/10/9.
 */
public class HeroStack {

    LinkedList<Hero> heros = new LinkedList<>();

    public static void main(String[] args) {
        HeroStack hs = new HeroStack();
        for(int i=0;i<=5;i++){
            Hero h = new Hero("HeroNo." + i);
            System.out.println("压入Hero: " + h.getName());
            hs.push(h);
        }

        for(int i=0; i<=5; i++){
            Hero h = hs.pull();
            System.out.println("弹出Hero:" + h.getName());
        }
    }

    public void push(Hero h){
        heros.addLast(h);
    }

    public Hero pull(){
        return heros.removeLast();
    }

    public Hero peek(){
        return heros.getLast();
    }




}
