package com.company.caini.array;

import java.util.Scanner;

/**
 * Created on 2018/5/15.
 * @author Batman
 */
public class CycliTest {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("请输入您的身高(m):");
        float a = s.nextFloat();
        System.out.println("请输入您的体重(KG):");
        float b = s.nextFloat();
        float c = b/(a*a);
        System.out.println("您的BMI指数为\n"+c);
        if(c<18.5) {
            System.out.println("你的体重过轻");}
        else if(18.5<=c&&c<24.0) {
            System.out.println("你的体重在正常范围");}
        else if(24<=c&&c<27) {
            System.out.println("你的体重过重");}
        else if(27<=c&&c<30) {
            System.out.println("你是轻度肥胖");}
        else if(30<=c&&c<35) {
            System.out.println("你是中度肥胖");}
        else if(c<35) {
            System.out.println("你是重度肥胖");
        }

    }


}
