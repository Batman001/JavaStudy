package com.test.character;

/**
 * Created on 2018/7/26.
 * @author Batman
 */
public class EnemyHeroIsDeadException extends Exception {
    public EnemyHeroIsDeadException(){}
    public EnemyHeroIsDeadException(String msg){
        super(msg);
    }
}
