package com.company.caini.digitstring;
import java.util.Random;
/**
 * Created by sunchao on 2018/7/4.
 */
public class CombineTest {
    public static void main(String[] args) {
        String garen = "盖伦";  // 字面值,虚拟机碰到字面值就会创建一个字符串对象

        String teemo = new String("提莫");  //创建了两个字符串对象

        char[] cs = new char[]{'崔', '斯', '特'};

        String hero = new String(cs);    // 通过字符数组创建一个字符串对象

        String hero2 = garen + teemo;    // 通过+号进行字符串拼接


//        由于String设置的关键字是final,这里不能被继承
//        static class myString extends String{
//        }

        System.out.println(garen.length());;
        System.out.println("".length());
        System.out.println(init());
        System.out.println(randomString(8));
    }

    public static String init(){
        // 生成全部字符的字符串
        StringBuilder builder = new StringBuilder();
        for(char i='0';i<='9';i++){
            builder.append(i);
        }
        for(char i='a';i<='z';i++){
            builder.append(i);
        }
        for(char i='A';i<='Z';i++){
            builder.append(i);
        }
        return builder.toString();
    }

    public static String randomString(int len){
        // 调用随机方法 随机挑选固定长度的字符串
        if(len <= 0)
            return "";
        String str = init();
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        for(int i=0;i<len;i++){
            int index = random.nextInt(str.length());
            char c = str.charAt(index);
            builder.append(c);
        }
        return builder.toString();
    }

    public static String charArraySort(){

        return "";
    }








}
