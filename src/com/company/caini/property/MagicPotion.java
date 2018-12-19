package com.company.caini.property;

/**
 * Created by sunchao on 2018/6/28.
 */
public class MagicPotion extends Item {
    @Override
    public boolean disposable() {
        return true;
    }

    @Override
    public void effect(){
        System.out.println("蓝瓶使用后,可以恢复魔法");
    }


}
