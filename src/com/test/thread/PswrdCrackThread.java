package com.test.thread;

import java.util.Random;

/**
 * Created by Batman on 2018/10/10.
 * @author Batman
 */
public class PswrdCrackThread {

    public static void main(String[] args) {
        String str = randomString(10);
        System.out.println("生成的密码是" + str);
        crack(str);
    }

    private static void crack(String pswd){
        Thread t = new Thread(){
            @Override
            public void run(){
                char[] ch = pswd.toCharArray();
                String py = "";
                for(int i=0;i<pswd.length();i++){
                    while(true){
                        String a = randomString(1);
                        char b = a.charAt(0);
                        log(b);
                        if (b==ch[i]){
                            py += b;
                            break;
                        }
                    }
                }
                System.out.println("破解成功,密码是:" + py);
            }
        };
        t.start();
    }



    public static String init(){
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



    private static void log(char a){
        Thread thread = new Thread(){
            @Override
            public void run(){
                System.out.println("使用字符" + a + "匹配");
            }
        };
        thread.setDaemon(true);
        thread.start();
    }


}
