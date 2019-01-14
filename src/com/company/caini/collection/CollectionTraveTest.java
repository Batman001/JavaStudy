package com.company.caini.collection;

import com.company.caini.character.Hero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Created on 2018/8/1.
 * @author Batman
 */
public class CollectionTraveTest {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();

        for(int i=0;i<5;i++){
            heros.add(new Hero("hero "+i, 100.f));
        }

        // 使用迭代器遍历
        System.out.println("-------使用while的iteration-----------");
        Iterator<Hero> it = heros.iterator();
//        从最开始的位置判断下一个位置是否有数据
//        如果有就通过next取出来,并且把指针向下移动
//        知道"下一个"位置没有数据
        while(it.hasNext()){
            Hero h = it.next();
            System.out.println(h);
        }


        // 迭代器的for写法
        System.out.println("--------使用for的iterator------------");
        for(Iterator<Hero> iterator = heros.iterator(); iterator.hasNext();){
            Hero hero = iterator.next();
            System.out.println(hero);
        }


        // 增强型for循环遍历写法
        System.out.println("--------增强型for循环------------");
        for(Hero h : heros){
            System.out.println(h);
        }
    }
}
