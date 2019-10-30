package com.test.property;

/**
 * Created on 2018/6/28.
 * @author Batman
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
