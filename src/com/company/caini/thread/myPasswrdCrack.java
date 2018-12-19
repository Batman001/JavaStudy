package com.company.caini.thread;

import java.util.Random;

/**
 * Created by sunchao on 2018/10/12.
 * @author sunchao
 */
public class myPasswrdCrack extends Thread {
    private String pswd;

    public myPasswrdCrack(String str){
        this.pswd = str;
    }
    public static void main(String[] args) {
        String pswd = randomString(10);
        System.out.println("当前随机生成密码是:" + pswd);
        myPasswrdCrack t1 = new myPasswrdCrack(pswd);
        t1.start();

    }

    private static String randomString(int len) {

        if(len<=0){
            return "";
        }
        String allChar = init();
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<=len;i++){
            int index = random.nextInt(allChar.length());
            builder.append(allChar.charAt(index));
        }
        return builder.toString();

    }

    private static String init(){
        StringBuilder sb = new StringBuilder();
        for(char i='0';i<='9';i++){
            sb.append(i);
        }
        for(char i='a';i<='z';i++){
            sb.append(i);
        }
        for(char i='A';i<='Z';i++){
            sb.append(i);
        }
        return sb.toString();
    }

    public static void pwdCrack(String pswd){
        char[] ch = pswd.toCharArray();
        String py = "";
        for(int i=0;i<ch.length;i++){
            while(true){
                String a = randomString(1);
                char b = a.charAt(0);
                // 守护进程,随时打印匹配的日志
                log(b);
                if(ch[i] == b){
                    py += b;
                    break;
                }
            }
        }
        System.out.println("密码破解成功,密码是:" + py);

    }

    public static void log(char a){
        Thread t = new Thread(){
            @Override
            public void run(){
                System.out.printf("当前使用字符为:%s进行破解%n",a);
            }
        };
        t.setDaemon(true);
        t.start();


    }

    @Override
    public void run(){
        pwdCrack(pswd);
    }

}
