package com.company.caini.character;

/**
 * Created on 2018/6/28.
 * @author Batman
 */
public interface AD {
    /** 物理伤害 */
    public void physicaAttack();

    default public void attack(){
        System.out.println("这是AD接口的attack");
    }
}
