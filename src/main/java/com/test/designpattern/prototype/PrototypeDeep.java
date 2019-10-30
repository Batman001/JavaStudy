package com.test.designpattern.prototype;


import java.util.ArrayList;

/**
 * @author Batman create on 2019-04-23 14:57
 * clone后，即使原型对象中list的值改变，也不会影响clone对象。
 * 实现方法:
 * 1、对象内部所有引用型对象都进行clone。
 * 2、对象序列化
 * 此处为第一种实现方法
 */
public class PrototypeDeep implements Cloneable {
    private static final long serialVersionUID = -1251595400978173322L;
    private ArrayList<String> list = new ArrayList<>();
    private int mInt;

    public ArrayList<String> getList() {
        return list;
    }

    public int getmInt() {
        return mInt;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public void setmInt(int mInt) {
        this.mInt = mInt;
    }

    @Override
    public PrototypeDeep clone(){
        PrototypeDeep prototypeDeep = null;
        try {
            prototypeDeep = (PrototypeDeep) super.clone();
            // deep clone
            prototypeDeep.list = (ArrayList)this.list.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototypeDeep;
    }
}
