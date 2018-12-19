package com.company.caini.collection;

import com.company.caini.character.Hero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sunchao on 2018/8/2.
 * @author sunchao
 */
public class HashMapSearch {
    public static void main(String[] args) {
        // 初始化3百万个数据
        List<Hero> heros = new ArrayList<>();
        System.out.println("初始化开始");
        for(int i=0;i<3000000;i++){
            heros.add(new Hero("Hero-" + (int)((Math.random() * 9000) + 1000)));
        }

        System.out.println("初始化数据结束");
        System.out.println("开始查找");
        dumpSearchOfMap(heros, "Hero-5555");
        dumpSearchOfIteration(heros, "Hero-5555");

    }

    private static void dumpSearchOfMap(List<Hero> heros, String s) {
        long start = System.currentTimeMillis();
        HashMap<String,List<Hero>> m = new HashMap<>();
        // key:英雄名字  value:同一个名字的全部英雄组成的列表
        for(Hero h : heros){
            List<Hero> currentList = m.get(h.name);
            if (currentList == null) {
                currentList = new ArrayList<>();
                m.put(h.name, currentList);
            }
            currentList.add(h);
        }

        List<Hero> result = m.get(s);
        long end = System.currentTimeMillis();
        System.out.printf("通过HashMap一共查找到%d个英雄,共计耗时%d毫秒%n", result.size(), end-start);


    }

    private static void dumpSearchOfIteration(List<Hero> heros, String name) {
        long start = System.currentTimeMillis();
        List<Hero> result = new ArrayList<>();
        for(Hero h:heros){
            if(h.getName().equals(name)){
                result.add(h);
            }
        }

        long end = System.currentTimeMillis();
        System.out.printf("通过For循环一共查找到%d个英雄,共计耗时%d毫秒%n", result.size(), end-start);

    }

//    public static void dumpSearchOfMap(List<Hero> heros, String name){
//        long start = System.currentTimeMillis();
//        HashMap<String,List<Hero>> hs = new HashMap<>();
//        for(Hero h:heros){
//            // 名字作为key
//            // 名字相同的英雄,放到一个List中,作为value
//            List<Hero> list = hs.get(h.name);
//            if(list == null){
//                list = new ArrayList<>();
//                hs.put(h.getName(), list);
//            }
//            list.add(h);
//        }
//
//        List<Hero> result = hs.get(name);
//        long end = System.currentTimeMillis();
//        System.out.printf("通过map查找一共查找到%d个英雄,共计耗时%d毫秒%n", result.size(), end-start);
//
//    }


}
