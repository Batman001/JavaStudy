package com.company.caini.collection;

import java.util.*;

/**
 * Created by Batman on 2018/8/3.
 * @author Batman
 */
public class HashSet<E> extends AbstractSet<E> implements Set<E>,Cloneable,java.io.Serializable {

    /**
     * HashSet里封装了一个HashMap
     */

    private HashMap<E,Object> map;

    private static final Object PRESENT = new Object();

    /**
     * HashSet的构造方法初始化这个HashMap
     */

    public HashSet(){
        map = new HashMap<E, Object>();
    }


    /**
     * 向HashSet中增加元素,其实就是把该元素作为Key,增加到map中
     * value是PRESENT,静态,final的对象,所有的HashSet都是用这么同一个对象
     * @param e
     * @return
     */

    @Override
    public boolean add(E e){
        return map.put(e,PRESENT) == null;
    }


    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }
}
