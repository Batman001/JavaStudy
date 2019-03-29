package com.company.caini.digitstring;

import java.lang.String;
import java.lang.Integer;

/**
 * Created by Batman on 2018/7/3.
 */
public class TestNumber {
    public static void main(String[] args){
        // 数字转字符串
        int i=5;
        String str = String.valueOf(i);

        Integer it = i;
        String str2 = it.toString();

        System.out.println(str instanceof String);
        System.out.println(str2 instanceof String);

        // 字符串转数字
        String str3 = "999";
        int s = Integer.parseInt(str3);
        System.out.println(s);

        // float类型转字符串
        float f = 3.14f;
        String f1 = String.valueOf(f);
        System.out.println(f1 instanceof String);

        String fs = "3.14";
        float f2 = Float.parseFloat(fs);
        System.out.println(f2 + 3.23f);


        // 基本类型转封装类
        Integer i2 = new Integer(i);
        // 封装类型转换成基本类型
        int i3 = i2.intValue();


        // 自动装箱
        // 不需要调用构造方法,通过 = 符号自动把基本类型转换成类类型 称为装箱
        Integer it2 = i;


        // 自动转换称为拆箱
        int i4 = it;

        // int的最大值.最小值
        System.out.println("Integer的最大值为:"+Integer.MAX_VALUE);
        System.out.println("Integer的最小值为:"+Integer.MIN_VALUE);

        byte a = 1;
        Byte a1 = a;   // 自动装箱
        byte a2 = a1;  // 自动拆箱

        short b = 2;
        Short b1 = b;
        short b2 = b1;

        float c = 3.34f;
        Float c1 = c;
        float c2 = c1;

        double d = 4;
        Double d1 = d;
        double d2 = d1;

        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);


        // 浮点数转成字符串

        System.out.println(String.valueOf(c));

        // 先装箱封装成对象 然后使用toString方法
        System.out.println(c1.toString());

        // 字符串转成浮点数

        String g = "1.24";
        System.out.println(Float.parseFloat(g));

        System.out.println();
        //System.out.println(Float.parseFloat(g1));











    }
}
