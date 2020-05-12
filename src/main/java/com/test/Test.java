package com.test;

import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunc
 * Date 2019/11/15 17:24
 * Description
 */
public class Test {
    public static void main(String[] args) {
        List<Object> dataList = new ArrayList<>();
        Object obj = new Object();
        dataList.add(obj);
        System.out.println(obj.toString().startsWith("java.lang.Object"));

    }
}
