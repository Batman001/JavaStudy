package com.test.collection;

import com.test.character.Hero;

import java.util.HashMap;

/**
 * Created by Batman on 2018/8/2.
 * @author Batman
 */
public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String,String> dictionary = new HashMap<>();
        dictionary.put("adc","物理英雄");
        dictionary.put("apc", "魔法英雄");
        dictionary.put("t", "坦克");

//        System.out.println(dictionary.get("t"));

        HashMap<String, Hero> heromap = new HashMap<>();

        heromap.put("gareen", new Hero("garen", 190.f));
        System.out.println(heromap);

        // key作为gareen已经有value了,再以曾经出现的key放入数据,会覆盖之前value
        heromap.put("gareen", new Hero("garen1", 190.f));

        System.out.println(heromap);

        // 清空map
        heromap.clear();
        // 同一个对象可以作为值插入HashMap中
        Hero gareen = new Hero("gareen", 190.f);
        heromap.put("gareen1", gareen);
        heromap.put("gareen2", gareen);
        System.out.println(heromap);

    }


}
