package com.company.caini.digitstring;
import java.lang.Math;


/**
 * Created by Batman on 2018/7/4.
 */
public class TestMath {

    public static boolean isPrimeNumber(int num){
        if(num == 1) return true;
        if(num == 2) return true; // 数字2特殊处理
        if(num < 2 || num % 2==0) return false; //识别小于2的数和偶数

        // 质数首先就是一个奇数
        // 如果一个数为奇数且不是质数,那么它一定可以通过两个自然数相乘得到,其中一个大于或等于其平方根,另一个小于或等于其平方根

        for(int i=3; i<=Math.sqrt(num); i+=2){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        float f1 = 5.4f;
        float f2 = 5.5f;

        //5.4四舍五入即为5
        System.out.println(f1 + "四舍五入后的结果为:"+Math.round(f1));
        System.out.printf(f2+ "四舍五入后的结果为:"+Math.round(f2));

        // 得到0-1之间的一个随机浮点数(取不到1)
        System.out.println(Math.random());

        // 得到0-10之间的一个随机整数(取不到10)
        System.out.println((int)Math.random() * 10);

        // 开方
        System.out.println(Math.sqrt(9));

        // 次方
        System.out.println(Math.pow(2,4));

        // 圆周率
        System.out.println(Math.PI);

        // 自然常数
        System.out.println("Math函数中自然常数的大小为:"+Math.E);


        // 通过公式计算E
        int n = Integer.MAX_VALUE;
        System.out.println(Math.pow(1+1d/n,n));


        // 计算一千万以内的数一共有多少个质数
        int num = 10000000;
        int count = 0;
        for(int i=0;i<num;i++){
            if (isPrimeNumber(i)){
                count += 1;
            }
        }

        System.out.println("一千万以内的质数的数量为"+count);

    }
}
