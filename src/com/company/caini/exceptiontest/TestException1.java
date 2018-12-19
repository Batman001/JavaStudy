package com.company.caini.exceptiontest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by sunchao on 2018/7/26.
 */
public class TestException1 {
    public static void main(String[] args){
        method1();
    }

    private static void method1() {
        try{
            method2();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("文件路径错误,请注意修改");
            File f1 = new File("/Users/sunchao/Desktop/personInfo.txt");
            System.out.println(f1);
        }
    }

    private static void method2() throws FileNotFoundException{
        File f = new File("/Users/sunchao/Desktop/personInfo");
        System.out.println("尝试打开文件");
        new FileInputStream(f);
        System.out.println("成功打开文件");
    }
}
