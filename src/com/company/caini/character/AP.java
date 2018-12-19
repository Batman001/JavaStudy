package com.company.caini.character;

/**
 * Created by sunchao on 2018/6/28.
 */
public interface AP {
    public void magicAttack();

    /*
    接口中声明的属性只能是
    public 静态的
    final 没有显示的声明
     */
    public static final int resisPhysic = 100;
    int resisMagic = 0;

    default public void attack(){
        System.out.println("这是AP接口的attack");
    }
}
