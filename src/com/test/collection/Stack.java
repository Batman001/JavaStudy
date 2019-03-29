package com.company.caini.collection;

import com.company.caini.character.Hero;

/**
 * Created by Batman on 2018/8/1.
 */
public interface Stack {
    public void push(Hero h);
    public Hero pull();
    public Hero peek();
}
