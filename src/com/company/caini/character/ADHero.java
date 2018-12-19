package com.company.caini.character;

import com.company.caini.property.LifePotion;
import com.company.caini.property.Mortal;
import com.company.caini.property.Item;

/**
 * Created by sunchao on 2018/6/25.
 */
/*
public class ADHero extends Hero {

    public void attack(){
        System.out.println(name + "进行了一次攻击,但是不确定打中了谁");
    }

    public void attack(Hero h1){
        System.out.println(name + "对" + h1.name + "进行了一次攻击 ");
    }

    public void attack(Hero h1, Hero h2) {
        System.out.println(name + "同时对" + h1.name + "和" + h2.name + "进行了攻击 ");
    }

    public static void main(String[] args){
        ADHero bh = new ADHero();
        bh.name = "赏金猎人";
        Hero h1 = new Hero();
        h1.name = "盖伦";
        Hero h2 = new Hero();
        h2.name = "提莫";
        bh.attack();
        bh.attack(h1);
        bh.attack(h1,h2);
    }
}
*/
/*
使用可变数量的参数, 控制英雄的数量, 只需要设置一个attack方法就可以实现多个参数实现attack方法

 */
public class ADHero extends Hero implements AD,Mortal{


    public ADHero(String heroName, float heroHp) {
        super(heroName, heroHp);
        System.out.println("ADHero的构造方法");
    }

    int moveSpeed = 400;

    @Override
    public void physicaAttack() {
        System.out.println("进行物理攻击");
    }

    @Override
    public void die(){
        System.out.println(this.name + "我作为一个射手英雄是很脆皮的");
    }

    public void attack(){
        System.out.println(name + "进行一次攻击,但是不确定打中了谁");
    }

    // 可变数量参数
    public void attack(Hero...heros){
        for(int i=0; i<heros.length; i++){
            System.out.println(name + "攻击了" + heros[i].name);
        }
    }

    // 覆盖父类方法 (子类隐藏父类方法)
    public static void battleWin(){
        System.out.println("ad hero battle win");
    }

    public int getMoveSpeed(){
        return this.moveSpeed;  // 返回子类的moveSpeed的属性
    }
    // 通过super 调用父类属性
    public int getMoveSpeed2(){
        return super.moveSpeed; // 返回父类的moveSpeed的属性

    }


    // 重写父类useItem方法
    public void useItem(Item i){
        System.out.println("ADHero use item");
        super.useItem(i);
    }
    public static void main(String[] args){
        ADHero bh = new ADHero("赏金猎人", 100.f); // 实例化一个子类对象,会先调用父类的构造方法,然后调用本身的构造方法.

        //Hero h1 = new Hero("盖伦",50.5f);

        //Hero h2 = new Hero("提莫", 56.f);
        bh.attack();
        //bh.attack(h1);
        //bh.attack(h1,h2);

        // 类方法调用最好使用  类.类方法 的方式进行调用.
        ADHero.battleWin();
        Hero.battleWin();

        System.out.println("没有调用父类属性的移动速度" + bh.getMoveSpeed());
        System.out.println("调用父类属性的移动速度" + bh.getMoveSpeed2());

        LifePotion lp = new LifePotion();
        bh.useItem(lp);


//      假设没有默认方法这种机制，那么如果要为Mortal增加一个新的方法revive,那么所有实现了Mortal接口的类，都需要做改动。
//      但是引入了默认方法后，原来的类，不需要做任何改动，并且还能得到这个默认方法
//      通过这种手段，就能够很好的扩展新的类，并且做到不影响原来的类
        bh.revive();
    }


}

