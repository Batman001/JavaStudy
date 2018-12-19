package com.company.caini.collection;

import com.company.caini.character.APHero;
import com.company.caini.character.Hero;
import com.company.caini.character.HeroItem;
import com.company.caini.property.ItemSon;

import java.util.ArrayList;
import java.util.List;

/*
不指定泛型的容器,可以存放任何类型的元素
 */
/**
 * Created by sunchao on 2018/8/1.
 */
public class TestCollectionGeneric {
    public static void main(String[] args){
        // 对于不适用泛型的容器, 可以往里面存放英雄,也可以往里面放物品
        List heros = new ArrayList();

        heros.add(new Hero("Garen", 199.f));

        // 本来用来存放英雄的容器, 现在可以存放物品了
        heros.add(new ItemSon("冰杖"));

        // 由于不清楚容器某个位置存放对象的类型,在对象转型的时候会出现问题
        Hero h1 = (Hero)heros.get(0);

//        Hero h2 = (Hero)heros.get(1);
//        System.out.println(h2);

        // 引入泛型Generic
        // 生命容器的时候,就指定了这种容器,只能放Hero,存放其他的就会出错
        List<Hero> genericheros = new ArrayList<Hero>();  // List 是接口 不能被实例化
        genericheros.add(new Hero("Teemo", 120.f));
//        genericheros.add(new ItemSon("制裁之刃"));

//        除此之外,还可以存放Hero的子类
        genericheros.add(new APHero("貂蝉", 130.f));

        // 在读取数据的时候不需要进行转型,因为里面一定是Hero类或者其子类
        Hero h = genericheros.get(1);
        System.out.println(h);


        /*
        设计ArrayList中,既可以存放Hero,也可以存放Item
        由于两者为不同的类型,所以设计接口,让两者共同实现,则可以同时放进同一个容器内
         */

        List<HeroItem> generic2 = new ArrayList<>();
        generic2.add(new Hero("狄仁杰", 120.f));
        generic2.add(new ItemSon("众神之锤"));

        System.out.println(generic2.get(0));
        System.out.println(generic2.get(1));



    }

}
