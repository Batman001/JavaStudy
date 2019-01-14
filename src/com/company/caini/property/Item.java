package com.company.caini.property;


/**
 * Created on 2018/6/28.
 * @author Batman
 */
public abstract class Item {
    public String name;
    protected int price;

    public void buy(){
        System.out.println("购买装备");
    }

    public abstract boolean disposable();

    public void effect(){
        System.out.println("物品使用后,可以有效果");
    }

    public void attack(){
        System.out.println("使用武器进行攻击");
    }

    public static void main(String[] args){

        // 多态的使用
        /**
         * 多态的条件
         * (1) 父类(接口)引用子类对象
         * (2) 调用方法有重写
         */
        Item i1 = new LifePotion();
        Item i2 = new MagicPotion();
        Item i3 = new Weapon();

        System.out.print("i1是Item类型，执行effect打印:");
        i1.effect();
        System.out.print("i2也是Item类型，执行effect打印:");
        i2.effect();


        System.out.println(i1.disposable());

        System.out.println(i2.disposable());

        System.out.println(i3.disposable());



        Item i4 = new Item(){
            @Override
            public boolean disposable(){
                System.out.println("这是在匿名类里面重写的抽象方法");
                return false;
            }
        };
        System.out.println(i4.disposable());
    }


}
