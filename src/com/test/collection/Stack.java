package com.test.collection;

import com.test.character.Hero;

/**
 * Created by Batman on 2018/8/1.
 */
public interface Stack {
    public void push(Hero h);
    public Hero pull();
    public Hero peek();
}
