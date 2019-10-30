package com.test.collection;

import com.test.character.Hero;

import java.util.ArrayList;

/**
 * Created by Batman on 2018/7/31.
 */
public class TestCollection {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args){
        ArrayList heros = new ArrayList();
        heros.add(new Hero("garen", 190.f));
        System.out.println(heros.size());

        heros.add(new Hero("teemo", 120.f));
        System.out.println(heros.size());
        System.out.println(heros.get(0));
        System.out.println(heros.get(1));

        Hero garen = new Hero("garen", 190.f);
        System.out.println(heros.contains(garen));

        for(int i=0;i<5;i++){
            heros.add(new Hero("hero" + String.valueOf(i), 100.f));
        }

        Hero specialHero = new Hero("SpecialHero", 230.f);
        heros.add(specialHero);

        System.out.println("SpeceialHero所处的位置是" + heros.indexOf(specialHero));


        System.out.println("删除前打印arrayList全部的对象为");
        printArray(heros);

        System.out.println("删除下标是2的对象");
        heros.remove(2);

        System.out.println("删除SpecialHero对象");
        heros.remove(specialHero);

        System.out.println("打印arrayList全部的对象为");
        printArray(heros);


        // 替换操作
        heros.set(5, new Hero("hero5", 190.f));

        printArray(heros);

        // 直接打印ArrayList情况
        //System.out.println(heros);

        // 转换成数组
        // 如果要转换成一个Hero数组,需要传递一个Hero数组类型的对象给toArray(),
        Hero hs[] = (Hero[]) heros.toArray(new Hero[]{});
        System.out.println("数组" + hs);


        // 把另一个容器的全部对象都加进来
        ArrayList anatherHeros = new ArrayList();
        for (int i=10;i<=15;i++){
            anatherHeros.add(new Hero("hero"+i, 100.f));
        }

        System.out.printf("另一个新建数组是:%n" + anatherHeros);
        System.out.println();


//        heros.addAll(anatherHeros);

//        System.out.println("将另一个Arraylist的数组全部添加进heros ArrayList中,其结果为: ");
//        System.out.println(heros);

//        使用clear清空
//        heros.clear();
//        System.out.println("清空之后的heros的内容为 : ");
//        System.out.println(heros);

        String matchName = "hero1";
        for(int i=0;i<heros.size();i++){
            // 非静态方法 必须实例化一个对象才可以调用其方法
            Hero h = (Hero)heros.get(i); // Arraylist中的应用是Object类型,需要拆箱,向下转型
            if (h.getHeroName().equals(matchName)) {
                System.out.printf("找到了name是%s的对象%n", matchName);
                break;
            }
        }

    }

    public static void printArray(ArrayList arr){
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
    }

}
