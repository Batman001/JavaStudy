package com.test.character;

/**
 * Created on 2018/6/27.
 * @author Batman
 */
public class TestGiantDragon {
    public static void main(String[] args){
        // 通过new 实例化会报错
        //GiantDragon gd = new GiantDragon();
        //只能通过getInstance得到对象
        GiantDragon g1 = GiantDragon.getInstance();
        GiantDragon g2 = GiantDragon.getInstance();


        if (g1 == g2){
            System.out.println("实例化得到的大龙的对象是完全一样的");
        }

        SingleHero sh = SingleHero.getInstance();

        System.out.println(sh.name);
    }

}

