package com.test.designpattern.prototype;

import java.util.ArrayList;

/**
 * @author Batman create on 2019-04-23 14:44
 * 实现方法:
 * 浅拷贝方法  调用 java.lang.Object的clone()方法
 */
public class Prototype implements Cloneable {
    private static final long serialVersionUID = -1251595400978173322L;
    private ArrayList<String> arrayList = new ArrayList<>();
    private int mInt;

    public ArrayList<String> getList() {
        return arrayList;
    }

    public int getmInt() {
        return mInt;
    }

    public void setList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public void setmInt(int mInt) {
        this.mInt = mInt;
    }

    @Override
    public Object clone(){
        Prototype proto = null;
        try{
            proto = (Prototype) super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return proto;
    }

}
