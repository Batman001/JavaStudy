package com.test.designpattern.prototype;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Batman create on 2019-04-23 15:17
 * clone后，即使原型对象中list的值改变，也不会影响clone对象。
 * 实现方法:
 * 1、对象内部所有引用型对象都进行clone。
 * 2、对象序列化
 * 此处为第二种实现方法
 */
public class PrototypeDeepBySerial implements Cloneable, Serializable {
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

    /**
     * 使用序列化和反序列化实现深层复制
     * 深度拷贝
     * @return PrototypeDeepBySerial
     */
    public PrototypeDeepBySerial deepClone(){
        try{
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            byte[] bytes = bos.toByteArray();
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (PrototypeDeepBySerial) ois.readObject();

        }catch(IOException | ClassNotFoundException | NullPointerException e){
            e.printStackTrace();
        }
        return null;
    }
}
