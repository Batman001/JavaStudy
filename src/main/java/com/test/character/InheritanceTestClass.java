package com.test.character;

/**
 * Created on 2018/6/25.
 * @author Batman
 */

/**
 * class Armor 护甲
 */
class Armor{
    /**
     * 名称
     */
    String name;


    /**
     * 价格
     */
    int price;
}
class Item extends Armor{
    /**
     * 护甲等级
     */
    int ac;
}

class InheritanceTestClass {
    public static void main(String[] args){
        Item bujia = new Item();
        bujia.name = "布甲";
        bujia.price = 300;
        bujia.ac = 15;

        Item suozijia = new Item();
        suozijia.name = "锁子甲";
        suozijia.price = 500;
        suozijia.ac = 40;
    }


}
