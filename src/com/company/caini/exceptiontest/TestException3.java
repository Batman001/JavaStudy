package com.company.caini.exceptiontest;
import java.io.File;
import java.io.FileInputStream;
/**
 * Created by sunchao on 2018/7/26.
 */
public class TestException3 {
    public static void main(String[] args) {
        method1();
    }

    public static void method1() {
        try{
            method2();
        }
        catch(Throwable t) {
            System.out.println("系统打开失败");
            t.printStackTrace();
        }
    }

    public static void method2() throws Throwable{
        File f = new File("d:/LOL.exe");

        System.out.println("系统先尝试打开");
        new FileInputStream(f);
        System.out.println("系统打开成功");
    }
}
