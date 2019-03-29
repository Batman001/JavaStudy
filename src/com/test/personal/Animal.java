package com.company.caini.personal;
import java.lang.String;
/**
 * Created by Batman on 2018/7/3.
 */
public abstract class Animal {
    public Animal(){}
    String name;
    protected int legs;

    protected Animal(String nameOfAnimal, int legsOfNum){
        this.name = nameOfAnimal;
        this.legs = legsOfNum;
    }

    public abstract void eat();

    public void walk(){
        System.out.println(this.name + "使用"+this.legs+ "条腿走路");
    }

    public static void main(String[] args){
        Cat c = new Cat("小喵");
        System.out.println(c.name);
        c.play();
        c.walk();
        Cat c1 = new Cat();
        c1.SetName("小黑");
        c1.walk();

        Animal a = new Fish();
        a.name = "小鱼儿";
        System.out.println(a instanceof Fish);
        System.out.println(a.name);
        a.eat();  //null我只吃小虾米 由于Fish类中name用private关键字修饰


        Animal s = new Spider("spiderMan");
        s.eat();
        s.walk();

    }
}
