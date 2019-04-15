package com.test.collection;

import com.test.character.Hero;

import java.util.ArrayList;
import java.util.List;
/**
 * Created on 2018/8/1
 * @author Batman
 */

public class CollectionDeleteTest {
    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<>();
        for(int i=0;i<100;i++){
            heros.add(new Hero("hero "+i, 100.f));
        }

        // remove process
        // 设置count的目的是由于 删除前面元素后 后面的元素整个长度发生了变化
        int count = 0;
        for(int i=1;i<heros.size();i++) {
            if(i % 8 ==0){
                heros.remove(i - count);
                count += 1;
            }
        }

        for(Hero h:heros){
            System.out.println(h);
        }
    }


}

