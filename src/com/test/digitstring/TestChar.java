package com.test.digitstring;

import java.lang.String;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Batman on 2018/7/4.
 */
public class TestChar {

    public static  String randomString(int len){
        String pool = "";
        for(short i='0';i<='9';i++){
            pool += (char)i;
        }
        for(short i='a';i<='z';i++){
            pool += (char)i;
        }
        for(short i='A';i<='Z';i++){
            pool += (char)i;
        }
        //System.out.println("全部字符进行打印的结果为:"+pool);
        Random random = new Random();
        char[] rs = new char[len];
        for (int i=0;i<len;i++){
            //int index = (int)(Math.random() * pool.length());
            int index = random.nextInt(pool.length());
            rs[i] = pool.charAt(index);
        }
        return new String(rs);
    }


    public static String stringArraySortByFirstChar(String[] ss){
        System.out.println("未排序前的字符串数组为:"+ Arrays.toString(ss));
        // 冒泡排序思想
        for(int j=0;j<ss.length;j++){
            for(int i=0;i < ss.length-j-1;i++){
                char firstChar1 = Character.toLowerCase(ss[i].charAt(0));
                char firstChar2 = Character.toLowerCase(ss[i+1].charAt(0));

                if(firstChar1 > firstChar2){
                    String temp = ss[i];
                    ss[i] = ss[i+1];
                    ss[i+1] = temp;
                }

            }
        }
        return Arrays.toString(ss);
    }

    public static void main(String[] args){
        char c1 = 'a';
        char c2 = '1';
        char c3 = '中';
//        char c4 = 'ab';  只能放一个字符,这种情况是不允许的

        Character c = c1;  // 自动装箱
        c1 = c;            // 自动拆箱

        System.out.println(Character.isLetter(c1));
        System.out.println(Character.isDigit(c2));
        System.out.println(Character.isSpaceChar(' '));
        System.out.println(Character.isUpperCase('A'));
        System.out.println(Character.toLowerCase('A'));

        System.out.println("使用空格无法达到的对齐效果");
        System.out.println("abc def");
        System.out.println("ab def");
        System.out.println("a def");

        System.out.println("使用\\t可以达到对齐效果");
        System.out.println("abc\tdef");
        System.out.println("ac\tdef");
        System.out.println("a\tdef");


        Scanner input = new Scanner(System.in);
        System.out.println("请输入字符串:");
        String s = input.next();
        System.out.println("经过筛选后的字符串为:");
        char[] cs = s.toCharArray();
        for (char item:cs){
            if (Character.isUpperCase(item) || (Character.isDigit(item))){
                System.out.printf(String.valueOf(item));
            }
        }
        System.out.printf("%n");
        System.out.println("随机生成字符串为:"+randomString(10));


        // 字符串数组排序测试
        String[] ss = new String[8];
        for(int i=0;i<ss.length;i++){
            ss[i] = randomString(5);
        }
        System.out.println("排序后的字符串数组为:"+stringArraySortByFirstChar(ss));

    }

}
